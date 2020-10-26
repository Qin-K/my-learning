package com.qin_kai.validation.enums;

/**
 * @author qinkai
 * @date 2020/10/26
 */
public enum ResultCode {
    SUCCESS(0, "成功"),
    UPLOAD_FILE_ERROR(101, "上传文件格式错误"),
    FILE_NOT_FOUND(102, "请求的文件不存在"),
    MD5_CHECK_ERROR(103, "md5 校验失败"),
    ARGUMENT_ERROR(104, "传入参数有误"),
    MISSING_PARAM(105, "缺少参数"),
    UNSUPPORTED_METHOD(106, "不支持的方法"),
    INTERNAL_ERROR(500, "系统内部错误") ;
    /**
     * 响应码 0 成功
     */
    private int code;
    /**
     * 响应描述
     */
    private String desc;

    ResultCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
