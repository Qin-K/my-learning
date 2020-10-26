package com.qin_kai.validation.dto;

import com.qin_kai.validation.enums.ResultCode;

/**
 * @author qinkai
 * @date 2020/10/26
 */
public class HttpResult {

    private Integer code;

    private String desc;

    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static HttpResult success(String message, Object data) {
        HttpResult httpResult = new HttpResult();
        httpResult.code = ResultCode.SUCCESS.getCode();
        httpResult.desc = message;
        httpResult.data = data;
        return httpResult;
    }

    public static HttpResult success() {
        return success(ResultCode.SUCCESS.getDesc(), null);
    }

    public static HttpResult success(Object data) {
        return success(ResultCode.SUCCESS.getDesc(), data);
    }

    public static HttpResult success(String message) {
        return success(message, null);
    }

    public static HttpResult error(ResultCode resultCode) {
        HttpResult httpResponse = new HttpResult();
        httpResponse.code = resultCode.getCode();
        httpResponse.desc = resultCode.getDesc();
        return httpResponse;
    }

    public static HttpResult error(Integer code, String desc) {
        HttpResult httpResponse = new HttpResult();
        httpResponse.code = code;
        httpResponse.desc = desc;
        return httpResponse;
    }
}
