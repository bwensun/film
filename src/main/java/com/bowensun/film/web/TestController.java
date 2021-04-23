package com.bowensun.film.web;

import com.bowensun.film.common.properties.FilmProperties;
import com.bowensun.film.domain.UserPO;
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

    @Resource(name = "testUser")
    private UserPO user;


    @RequestMapping("demo")
    public String demo(){
        return "demo";
    }

    @RequestMapping("admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("normal")
    public void normal(){
        System.out.println("normal");
    }

    @PreAuthorize("@ss.hasPermi('index')")
    @RequestMapping("testIndexPermi")
    public String testIndexPermi(){
        return "testIndexPermi success!";
    }
}
