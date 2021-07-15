package com.bowensun.film.service.component;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.mail.MailUtil;
import org.springframework.stereotype.Component;

/**
 * 邮件服务
 * 对于邮件服务功能做进一步的包装
 *
 * @author 郑建雄
 * @date 2021/7/14
 */
@Component
public class EmailService {

    /**
     * 发送注册验证码
     *
     * @param to 目标邮箱
     * @param captcha 验证码
     *
     */
    public void sendRegisterCaptcha(String to, String captcha){
        String pattern = "【Film】您正在进行注册操作，验证码{}，切勿将验证码泄露于他人，本条验证码有效期5分钟。";
        String msg = StrUtil.format(pattern, captcha);
        MailUtil.send(to, "注册", msg, false);
    }
}
