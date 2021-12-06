package com.bowensun.film.web;

import com.alibaba.fastjson.JSON;
import com.bowensun.film.web.prototype.User;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Resource(name = "proUser")
    private User user;

    @RequestMapping("demo")
    public String demo() {
        return "demo";
    }

    @RequestMapping("admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping("normal")
    public void normal() {
        System.out.println("normal");
    }

    @PreAuthorize("@ss.hasPermi('index')")
    @RequestMapping("testIndexPermi")
    public String testIndexPermi() {
        return "testIndexPermi success!";
    }

    @RequestMapping("testUser")
    public void testUser() {
        System.out.println(JSON.toJSONString(user));
    }

    @RequestMapping("testLong")
    public Long testLong() {
        return 1L;
    }
}
