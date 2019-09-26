package com.bowensun.film.web;

import com.bowensun.film.common.config.redis.RedisCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author 郑建雄
 * @program film
 * @description
 * @date 2019/5/16
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class RedisControllerTest {
//
//    @Autowired
//    private RedisTemplate redisTemplate;
//    @Autowired
//    private ValueOperations valueOperations;
//    @Autowired
//    private RedisCache redisCache;
//
//
//    @Test
//    public void set() {
//        valueOperations.set("bowensun", "孙博文");
//    }
//
//    @Test
//    public void get() {
//        Object bowensun = valueOperations.get("bowensun");
//        System.out.println(bowensun+"--------");
//    }
//
//    @Test
//    public void remove() {
//        redisTemplate.delete("bowensun");
//    }
//
//
//    @Test
//    public void setTest(){
//        redisCache.set("zjx", "123");
//    }
//}