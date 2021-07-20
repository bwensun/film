package com.bowensun.film.service.component;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 描述
 *
 * @author 郑建雄
 * @date 2021/7/16
 */
@SpringBootTest
@ActiveProfiles(value = "druid")
class yuQueSDKComponentTest {

    @Resource
    private yuQueSDKComponent yuQueSDKComponent;


    @Test
    @DisplayName("测试语雀api")
    void getUserInfo() {
        yuQueSDKComponent.getUserInfo();
    }
}