package com.bowensun.film.web;

import com.bowensun.film.domain.USER;
import com.bowensun.film.repository.USERDynamicSqlSupport;
import com.bowensun.film.repository.USERMapper;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.bowensun.film.web.aop.log.LogT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 郑建雄
 * @program film
 * @description
 * @date 2019/3/18
 */
@RestController
@RequestMapping(value = "demo")
@Slf4j
public class DemoController {

    @Autowired

    private USERMapper userMapper;

    @PostMapping(value = "query")
    @LogT
    public List<USER> userDemo(){

        List<USER> users = userMapper.selectByExample().where(USERDynamicSqlSupport.name, isEqualTo("zjx"), or(USERDynamicSqlSupport.username, isEqualTo("千仞雪")))
                .build()
                .execute();
        //users.stream().forEach(x -> System.out.println(x.toString()));
        return users;
    }

    @LogT
    public static void test1(){

    }

    public void main(String[] args) {
        //ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            new Runnable() {
                @Override
                public void run() {
                    test1();
                }
            }.run();
        }
    }
}
