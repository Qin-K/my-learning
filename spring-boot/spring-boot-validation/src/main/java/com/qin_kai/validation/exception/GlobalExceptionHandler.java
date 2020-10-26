package com.qin_kai.validation.exception;

import com.qin_kai.validation.dto.HttpResult;
import com.qin_kai.validation.enums.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author qinkai
 * @date 2020/10/26
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 参数格式有误
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected HttpResult methodArgumentNotValid(MethodArgumentNotValidException exception) {
        return HttpResult.error(ResultCode.ARGUMENT_ERROR);
    }

    /**
     * 缺少参数
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected HttpResult missingServletRequestParameter(MissingServletRequestParameterException exception) {
        return HttpResult.error(ResultCode.MISSING_PARAM);
    }

    /**
     * 不支持的请求类型
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected HttpResult httpRequestMethodNotSupported(HttpRequestMethodNotSupportedException exception) {
        return HttpResult.error(ResultCode.UNSUPPORTED_METHOD);
    }

    /**
     * 业务层异常
     */
    @ExceptionHandler(ServiceException.class)
    protected HttpResult serviceException(ServiceException exception) {
        return HttpResult.error(exception.getCode(), exception.getMessage());
    }

    /**
     * 其他异常
     */
    @ExceptionHandler(Exception.class)
    protected HttpResult exception(Exception exception) {
        LOGGER.error("发生未知异常", exception);
        return HttpResult.error(ResultCode.INTERNAL_ERROR);
    }
}
