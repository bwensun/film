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
public class CaptchaGenDTO {

    /**
     * 用户主键
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 目标邮箱
     */
    private String to;

    /**
     * 验证码类型
     */
    private String captchaType;
}
