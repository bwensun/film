package com.bowensun.film.web;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.IdUtil;
import com.bowensun.film.common.annotation.LogT;
import com.bowensun.film.common.config.redis.RedisCache;
import com.bowensun.film.common.constant.BizConstant.*;
import com.bowensun.film.domain.base.Result;
import com.bowensun.film.domain.dto.CaptchaGenDTO;
import com.bowensun.film.domain.dto.CaptchaImageDTO;
import com.bowensun.film.domain.dto.CaptchaValidateDTO;
import com.bowensun.film.service.CaptchaService;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.bowensun.film.common.constant.BizConstant.CAPTCHA_EXPIRATION;
import static com.bowensun.film.common.constant.BizConstant.CAPTCHA_REGISTER_KEY;

/**
 * 验证码操作处理
 *
 * @author ruoyi
 */
@RestController
public class CaptchaController {

    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;

    @Resource
    private RedisCache redisCache;

    @Value("${custom.captcha.type:math}")
    private String captchaType;

    @Resource
    private CaptchaService captchaService;

    /**
     * 生成验证码
     */
    @LogT(functionName = "获取图片验证码")
    @GetMapping("captchaImage")
    public Result<?> getCode() {
        // 保存验证码信息
        String uuid = IdUtil.simpleUUID();
        String verifyKey = CAPTCHA_REGISTER_KEY + uuid;

        String capStr, code;
        BufferedImage image;

        // 生成验证码
        if (CaptchaType.MATH.equals(captchaType)) {
            String capText = captchaProducerMath.createText();
            capStr = capText.substring(0, capText.lastIndexOf("@"));
            code = capText.substring(capText.lastIndexOf("@") + 1);
            image = captchaProducerMath.createImage(capStr);
        } else {
            capStr = code = captchaProducer.createText();
            image = captchaProducer.createImage(capStr);
        }
        redisCache.setCacheObject(verifyKey, code, CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", os);
        } catch (IOException e) {
            return Result.error(e.getMessage());
        }
        String img = Base64.encode(os.toByteArray());
        CaptchaImageDTO imageDTO = CaptchaImageDTO.builder()
                .uuid(uuid)
                .img(img)
                .build();
        return Result.success(imageDTO);
    }

    @LogT(functionName = "获取验证码")
    @PostMapping("captcha/gen")
    public Result<?> captchaGen(@RequestBody CaptchaGenDTO captcha){
        captchaService.captchaGen(captcha);
        return Result.success();
    }

    @LogT(functionName = "验证验证码")
    @PostMapping("captcha/validate")
    public Result<?> captchaValidate(@RequestBody CaptchaValidateDTO captcha){
        boolean result = captchaService.captchaValidate(captcha);
        return Result.success(result);
    }
}
