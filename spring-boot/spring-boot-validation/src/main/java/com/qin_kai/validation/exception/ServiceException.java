package com.qin_kai.validation.exception;

import com.qin_kai.validation.enums.ResultCode;

/**
 * @author qinkai
 * @date 2020/10/26
 */
public class ServiceException  extends RuntimeException{

    private int code;

    public ServiceException(ResultCode resultCode) {
        super(resultCode.getDesc());
        this.code = resultCode.getCode();
    }

    public int getCode() {
        return code;
    }
}
