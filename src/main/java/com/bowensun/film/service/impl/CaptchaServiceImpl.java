package com.bowensun.film.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.bowensun.film.common.config.redis.RedisCache;
import com.bowensun.film.common.constant.BizConstant;
import com.bowensun.film.common.constant.CaptchaType;
import com.bowensun.film.common.constant.ExceptionEnum;
import com.bowensun.film.common.exception.BizException;
import com.bowensun.film.domain.dto.CaptchaGenDTO;
import com.bowensun.film.domain.dto.CaptchaValidateDTO;
import com.bowensun.film.service.CaptchaService;
import com.bowensun.film.service.component.EmailService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 验证码服务实现
 *
 * @author 郑建雄
 * @date 2021/7/15
 */
@Service
public class CaptchaServiceImpl implements CaptchaService {

    @Resource
    private EmailService emailService;

    @Resource
    private RedisCache redisCache;

    @Override
    public void captchaGen(CaptchaGenDTO captchaGenDto) {
        String captcha = RandomUtil.randomNumbers(6);
        //验证码存入redis
        String key = BizConstant.CAPTCHA_CODE_KEY.concat(captchaGenDto.getUserId().toString());
        redisCache.setCacheObject(key, captcha, 5, TimeUnit.MINUTES);
        //发送邮件 todo: 后面需要调整为异步发送
        CaptchaType captchaType = CaptchaType.valueOf(captchaGenDto.getCaptchaType());
        switch (captchaType){
            case register:
                emailService.sendRegisterCaptcha(captchaGenDto.getTo(), captcha);
                break;
            case login:
                break;
            default:
                throw BizException.of(ExceptionEnum.INTERNAL_ERROR.code, "验证码类型异常！");
        }
    }

    @Override
    public boolean captchaValidate(CaptchaValidateDTO captchaDto) {
        String key = BizConstant.CAPTCHA_CODE_KEY.concat(captchaDto.getUserId().toString());
        String captcha = redisCache.getCacheObject(key);
        return captchaDto.getExpectedCaptcha().equals(captcha);
    }
}
