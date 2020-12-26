package com.bowensun.film.common.support;

/**
 * 错误码
 *
 * @author bowensun
 */
public enum ErrorCode {
    INTERNAL_ERROR(500, "代码有问题"),
    USER_NOT_EXISTS(001, "用户不存在"),
    FILE_NOT_EXISTS(002, "文件不存在"),
    PASSWORD_NOT_CORRECT(003, "密码错误"),;
    public int code;
    public String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
