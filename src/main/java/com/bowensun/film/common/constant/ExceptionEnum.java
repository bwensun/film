package com.bowensun.film.common.constant;

/**
 * 异常枚举维护
 *
 * @author 郑建雄
 * @date 2021/4/25
 */
@SuppressWarnings("unused")
public enum ExceptionEnum {

    /* HTTP状态码 */
    INTERNAL_ERROR("500", "内部服务器错误"),

    AUTH_EXCEPTION("401", "认证异常"),

    /**
     * 用户不存在
     */
    USER_NOT_EXIST("1001", "用户不存在"),

    /**
     * 用户已冻结
     */
    USER_FROZEN("1002", "用户已冻结"),

    /**
     * 用户已删除
     */
    USER_DELETED("1003", "用户已删除"),

    /**
     * 用户名或密码错误
     */
    USER_PASSWORD_NOT_MATCH("1004", "用户名或密码错误"),
    ;

    public final String code;

    public final String message;

    ExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
