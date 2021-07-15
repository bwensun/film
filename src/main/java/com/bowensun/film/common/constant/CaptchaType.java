package com.bowensun.film.common.constant;

import lombok.AllArgsConstructor;

/**
 * 验证码类型
 *
 * @author 郑建雄
 * @date 2021/3/12
 */
@AllArgsConstructor
public enum CaptchaType {

    /**
     * 注册
     */
    register,

    /**
     * 登录
     */
    login,

}
