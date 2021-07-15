package com.bowensun.film.service;

import com.bowensun.film.domain.dto.CaptchaGenDTO;
import com.bowensun.film.domain.dto.CaptchaValidateDTO;

/**
 * 验证码服务
 *
 * @author 郑建雄
 * @date 2021/7/15
 */
public interface CaptchaService {

    /**
     * 发送验证码
     *
     * @param captcha 验证码
     */
    void captchaGen(CaptchaGenDTO captcha);

    /**
     * 验证验证码
     *
     * @param captcha 验证码
     * @return 验证结果
     */
    boolean captchaValidate(CaptchaValidateDTO captcha);
}
