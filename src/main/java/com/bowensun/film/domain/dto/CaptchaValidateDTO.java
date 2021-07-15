package com.bowensun.film.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * 验证码传输类
 *
 * @author 郑建雄
 * @date 2021/7/15
 */
@ToString
@Getter
@Setter
public class CaptchaValidateDTO {

    /**
     * 用户主键
     */
    private Long userId;

    /**
     * 预期的验证码
     */
    private String expectedCaptcha;
}
