package com.bowensun.film.web;

import com.bowensun.film.domain.USER;
import com.bowensun.film.domain.USERDynamicSqlSupport;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.bowensun.film.domain.UserInfo;
import com.bowensun.film.repository.USERMapper;
import com.bowensun.film.repository.UserInfoDao;
import com.bowensun.film.repository.UserRepository;
import com.bowensun.film.web.aop.log.LogT;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import java.util.List;


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
    private USERMapper userMapper;
    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "query")
    @LogT
    @ApiOperation(value = "根据用户名查询数据", notes = "测试DynamicSQL功能")
    public List<USER> userDemo(){
        PageHelper.startPage(1, 10);
        List<USER> users = userMapper.selectByExample() //.where(USERDynamicSqlSupport.name, isEqualTo("zjx"), or(USERDynamicSqlSupport.username, isEqualTo("千仞雪")))
                .build()
                .execute();
        return users;
    }

    @LogT
    @GetMapping(value = "/test1")
    public List<UserInfo> test1(){
        PageHelper.startPage(1, 10);
        List<UserInfo> userInfos = userInfoDao.selectUserInfoList();
        return userInfos;
    }


    @GetMapping(value = "/jpa")
    public List<UserInfo> test2(){
        PageHelper.startPage(1, 10);
        //List<UserInfo> userInfos = userInfoDao.findAll();
        Sort sort = new Sort(Sort.Direction.DESC, "state");
        List<UserInfo> userInfos = userRepository.findAll(sort);
        return userInfos;
    }
}
