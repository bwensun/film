package com.bowensun.film.service.impl;

import com.bowensun.film.common.config.redis.RedisCache;
import com.bowensun.film.common.constant.BizConstant;
import com.bowensun.film.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;


/**
 * 用户活跃度测试
 *
 * @author 郑建雄
 * @date 2021/7/11
 */
@SpringBootTest
@ActiveProfiles("druid")
class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Resource
    private RedisCache redisCache;

    @DisplayName("用户活跃度测试")
    @Test
    void activityAdjust() {
        userService.activityAdjust(1L, 1);
    }

    @DisplayName("用户活跃度重置")
    @Test
    void activityReset() {
        ZSetOperations.TypedTuple<Object> objectTypedTuple1 = new DefaultTypedTuple<>(2,2.0);
        ZSetOperations.TypedTuple<Object> objectTypedTuple2 = new DefaultTypedTuple<>(3,3.0);
        Set<ZSetOperations.TypedTuple<Object>> tuples = new HashSet<>();
        tuples.add(objectTypedTuple1);
        tuples.add(objectTypedTuple2);
        redisCache.setSortObject(BizConstant.ACTIVITY_RANK_KEY, tuples);
    }
}