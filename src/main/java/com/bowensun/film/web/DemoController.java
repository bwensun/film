package com.bowensun.film.web;

import com.alibaba.fastjson.JSON;
import com.bowensun.film.domain.USER;

import com.bowensun.film.repository.USERMapper;
import com.bowensun.film.repository.mybatis.UserInfoDao;
import com.bowensun.film.repository.jpa.UserRepository;
import com.bowensun.film.service.UserService;
import com.bowensun.film.web.aop.log.LogT;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @author 郑建雄
 * @program film
 * @description
 * @date 2019/3/18
 */
@RestController
@RequestMapping(value = "demo")
@Slf4j
@Api(value = "测试功能相关接口<DemoController>", tags = "DemoController", description = "测试功能相关接口")
public class DemoController {

    @Autowired
    private UserService userService;

    @LogT
    @GetMapping(value = "/userList")
    @ApiOperation(value = "根据用户名查询数据", notes = "测试DynamicSQL功能")
    public List<USER> selectUserInfoList(Integer pageNumber, Integer pageSize) {
        return userService.selectUserInfoList(pageNumber, pageSize);
    }

    @LogT
    @GetMapping(value = "/user/{uid}")
    public USER selectByPrimaryKey(@PathVariable Integer uid) {
        return userService.selectByPrimaryKey(uid);
    }

    @LogT
    @DeleteMapping(value = "/user/{uid}")
    public void deleteByPrimaryKey(@PathVariable Integer uid) {
        userService.deleteByPrimaryKey(uid);
    }

    @LogT
    @PutMapping(value = "/update")
    public void updateUser(USER user) {
        userService.updateByPrimaryKeySelective(user);
    }

    @LogT
    @PostMapping(value = "/insert")
    public void insertUser(USER user) {
        userService.insertByPrimaryKeySelective(user);
    }


    public static void main(String[] args) throws URISyntaxException {
        Object a = null;
        BigDecimal big = (BigDecimal) a;

    }

    @LogT
    @PostMapping(value = "/session")
    public void insertUser(HttpSession session) {
        userService.selectUserInfoList();
        System.out.println("============>进入");
        Object name = session.getAttribute("name");
        System.out.println(name);
    }

    @LogT
    @PostMapping(value = "/addsession")
    public void setSession(HttpSession session) {
        System.out.println("============>进入add");
        session.setAttribute("name", "123");
    }

    @LogT
    @PostMapping(value = "/export")
    public void export(HttpServletResponse response) {

    }
}
