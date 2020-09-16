package com.qin_kai.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class HttpServerInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel sc) throws Exception {
        ChannelPipeline pipeline = sc.pipeline();
        //处理http消息的编解码
        pipeline.addLast("httpServerCodec", new HttpServerCodec());
        //添加自定义的ChannelHandler
        pipeline.addLast("httpServerHandler", new HttpServerHandler());
    }
}