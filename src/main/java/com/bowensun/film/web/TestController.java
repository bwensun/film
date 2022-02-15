package com.bowensun.film.web;

import com.alibaba.fastjson.JSON;
import com.bowensun.film.web.prototype.User;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
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
@Api(tags = "测试接口(请忽略)")
@ApiSupport(order = Integer.MIN_VALUE)
public class TestController {

    @Resource(name = "proUser")
    private User user;

    @PostMapping("demo")
    public String demo() {
        return "demo";
    }

    @PostMapping("admin")
    public String admin() {
        return "admin";
    }

    @PostMapping("normal")
    public void normal() {
        System.out.println("normal");
    }

    @PreAuthorize("@ss.hasPermi('index')")
    @PostMapping("testIndexPermi")
    public String testIndexPermi() {
        return "testIndexPermi success!";
    }

    @PostMapping("testUser")
    public void testUser() {
        System.out.println(JSON.toJSONString(user));
    }

    @PostMapping("testLong")
    public Long testLong() {
        return 1L;
    }
}
