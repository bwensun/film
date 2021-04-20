package com.bowensun.film.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

/**
 * 验证码对象
 *
 * @author 郑建雄
 * @date 2021/4/20
 */
@Data
@Builder
public class CaptchaImageDTO {

    private String uuid;

    private String img;
}
