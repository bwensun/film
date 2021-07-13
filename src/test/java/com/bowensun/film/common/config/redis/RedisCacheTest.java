package com.bowensun.film.common.config.redis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;
import java.util.Set;


/**
 * 描述
 *
 * @author 郑建雄
 * @date 2021/7/13
 */
@SpringBootTest
@ActiveProfiles("druid")
class RedisCacheTest {

    @Resource
    private RedisCache redisCache;

    @Test
    @DisplayName("测试redis_scan命令")
    void scan() {
        Set<String> scan = redisCache.scan("dict*", 1000);
        scan.forEach(System.out::println);
    }
}