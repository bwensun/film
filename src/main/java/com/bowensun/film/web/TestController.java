package com.bowensun.film.web;

import com.bowensun.film.common.properties.CustomProperties;
import com.bowensun.film.domain.UserPO;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 测试控制器
 *
 * @author 郑建雄
 * @date 2021/2/1
 */
@RequestMapping("test")
@RestController
public class TestController {

    @Resource(name = "testUser")
    private UserPO user;

    @Resource
    private CustomProperties customProperties;

    /**
     * 测试EnableConfigurationProperties注解
     *
     */
    @RequestMapping("enableConfigurationProperties")
    public void testConfigurationProperties(){
        System.out.println(user);
    }

    /**
     * 测试@NestedConfigurationProperty注解
     *
     */
    @RequestMapping("nestedConfigurationProperty")
    public void testNestedConfigurationProperty(){
        System.out.println(customProperties.getTask().getSyncTimes());
        System.out.println(customProperties.getAuth().getName());
    }
}
