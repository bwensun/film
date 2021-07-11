package com.bowensun.film.service.impl;

import com.bowensun.film.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;


/**
 * 描述
 *
 * @author 郑建雄
 * @date 2021/7/11
 */
@SpringBootTest
@ActiveProfiles("druid")
class UserServiceImplTest {

    @Resource
    private UserService userService;

    @DisplayName("用户活跃度测试")
    @Test
    void activityAdjust() {
        userService.activityAdjust(1L, 1);
    }
}