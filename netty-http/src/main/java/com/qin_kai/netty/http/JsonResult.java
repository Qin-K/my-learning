package com.qin_kai.netty.http;

import lombok.Data;

/**
 * @author qinkai
 * @date 2023/9/20
 */
@Data
public class JsonResult<T> {

    private Integer code;

    private String message;

    private T data;

    public JsonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static JsonResult<Void> error(Integer code, String message) {
        return new JsonResult<>(code, message, null);
    }

    public static <T> JsonResult<T> success(T data) {
        return new JsonResult<>(200, "success", data);
    }
}
