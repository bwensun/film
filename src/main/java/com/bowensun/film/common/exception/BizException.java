package com.bowensun.film.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 业务异常类
 *
 * @author lkz
 * @date 2020/11/24 17:40
 **/
@Getter
@ToString(callSuper = true)
@AllArgsConstructor
public class BizException extends RuntimeException {
    /**
     * 异常状态码 设置为final不允许直接修改
     */
    public final String code;

    /**
     * 异常信息
     */
    public final String message;

    /**
     * 通过code和message构建业务异常
     */
    public static BizException of(String code, String message) {
        return new BizException(code, message);
    }
}
