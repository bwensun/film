package com.bowensun.film.common.constant;

import lombok.AllArgsConstructor;

/**
 * 异常类型
 *
 * @author 郑建雄
 * @date 2021/3/12
 */
@AllArgsConstructor
public enum ExceptionType {
    /**
     * 业务异常
     */
    BIZ_EXCEPTION("业务异常"),


    /**
     * 其他异常
     */
    OTHER_EXCEPTION("其他异常"),
    ;

    public final String desc;
}
