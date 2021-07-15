package com.bowensun.film.service.component;

import cn.hutool.core.util.RandomUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;


/**
 * 邮件功能测试
 *
 * @author 郑建雄
 * @date 2021/7/15
 */
@SpringBootTest
@ActiveProfiles(value = "druid")
class EmailServiceTest {

    @Resource
    private EmailService emailService;

    @Test
    @DisplayName("邮件功能测试")
    void send() {
        emailService.sendRegisterCaptcha("bwensun@foxmail.com", RandomUtil.randomNumbers(6));
    }
}