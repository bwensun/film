package com.bowensun.film.common.constant;

/**
 * 异常枚举维护
 *
 * @author 郑建雄
 * @date 2021/4/25
 */

public enum ExceptionEnum {

    /**
     * 账号不存在
     */
    USER_NOT_EXIST("001", "用户不存在"),

    /**
     * 该邮箱已被注册
     */
    USER_FROZEN("002", "用户已冻结"),

    /**
     * 邮件发送失败
     */
    USER_DELETED("003", "邮件发送失败"),

    ;

    public final String code;

    public final String message;

    ExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
