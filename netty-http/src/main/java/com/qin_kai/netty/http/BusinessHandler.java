package com.qin_kai.netty.http;

/**
 * @author qinkai
 * @date 2023/9/20
 */
public interface BusinessHandler<T> {

    JsonResult handle(T data);

}
