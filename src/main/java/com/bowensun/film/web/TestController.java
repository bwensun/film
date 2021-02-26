package com.bowensun.film.web;

import com.bowensun.film.domain.UserPO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    /**
     * 测试EnableConfigurationProperties注解
     *
     */
    @RequestMapping("enableConfigurationProperties")
    public void testConfigurationProperties(){
        System.out.println(user);
    }
}
