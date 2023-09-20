package com.qin_kai.netty.http;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * @author qinkai
 * @date 2023/9/20
 */
@Component
@Slf4j
public class HttpServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest httpRequest) throws Exception {
        HttpMethod method = httpRequest.method();
        if (HttpMethod.GET.equals(method)) {
            JsonResult<Void> errorResult = JsonResult.error(HttpResponseStatus.METHOD_NOT_ALLOWED.code(), HttpResponseStatus.METHOD_NOT_ALLOWED.reasonPhrase());
            writeResponse(ctx, false, errorResult);
            return;
        }

        String path = httpRequest.uri();
        int markIndex = path.indexOf("?");
        if (markIndex != -1) {
            path = path.substring(0, markIndex);
        }
        BusinessHandler handler = BusinessHandlerRegistry.getHandler(path);
        if (handler == null) {
            JsonResult<Void> errorResult = JsonResult.error(HttpResponseStatus.NOT_FOUND.code(), HttpResponseStatus.NOT_FOUND.reasonPhrase());
            writeResponse(ctx, false, errorResult);
            return;
        }

        Method[] handlerMethods = ReflectionUtils.getDeclaredMethods(handler.getClass());
        Method handleMethod = Arrays.stream(handlerMethods)
                .filter(handlerMethod -> handlerMethod.getName().equals("handle") && handlerMethod.getParameterCount() == 1)
                .findAny().get();
        Class<?> parameterType = handleMethod.getParameterTypes()[0];
        String body = httpRequest.content().toString(StandardCharsets.UTF_8);
        Object data;
        try {
            data = JsonUtil.parse(body, parameterType);
        } catch (Exception ex) {
            JsonResult<Void> errorResult = JsonResult.error(HttpResponseStatus.BAD_REQUEST.code(), HttpResponseStatus.BAD_REQUEST.reasonPhrase());
            writeResponse(ctx, false, errorResult);
            return;
        }
        JsonResult<Object> jsonResult = handler.handle(data);
        writeResponse(ctx, HttpUtil.isKeepAlive(httpRequest), jsonResult);
    }

    private void writeResponse(ChannelHandlerContext ctx, boolean keepAlive, JsonResult<?> jsonResult) {
        FullHttpResponse httpResponse = new DefaultFullHttpResponse(HTTP_1_1, HttpResponseStatus.OK, Unpooled.copiedBuffer(JsonUtil.toJsonStr(jsonResult), CharsetUtil.UTF_8));
        httpResponse.headers().set(HttpHeaderNames.SERVER, "eastmoney");
        httpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE, "application/json;charset=UTF-8");
        httpResponse.headers().setInt(HttpHeaderNames.CONTENT_LENGTH, httpResponse.content().readableBytes());
        httpResponse.headers().set(HttpHeaderNames.CONNECTION, keepAlive ? HttpHeaderValues.KEEP_ALIVE : HttpHeaderValues.CLOSE);
        ctx.writeAndFlush(httpResponse);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error("http exception", cause);
        ctx.close();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        // 超时断开连接
        if (evt instanceof IdleStateEvent) {
            log.debug("idle event");
            ctx.channel().close();
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }
}
