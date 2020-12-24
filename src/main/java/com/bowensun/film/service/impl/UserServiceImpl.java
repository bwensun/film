package com.bowensun.film.service.impl;

import com.bowensun.film.domain.USER;
import com.bowensun.film.repository.USERMapper;
import com.bowensun.film.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description
 *
 * @author bowensun
 * @date 2018/11/9
 */
@Service
@CacheConfig
@PropertySources({@PropertySource("classpath:test.properties")})
public class UserServiceImpl implements UserService {

    @Autowired
    private USERMapper userMapper;

    @Value("${test.url}")
    private String testUrl;


    @Override
    public List<USER> selectUserInfoList() {
        //PageHelper.startPage(1, 10);
        return userMapper.selectByExample().build().execute();
        //return new PageInfo<USER>(userList);
    }

    //@Cacheable(cacheNames = "userList", key = "'userList:'+#pageNumber+'_'+#pageSize")
    @Override
    public PageInfo<USER> selectUserInfoList(Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return new PageInfo<>(userMapper.selectByExample().build().execute());
    }

    @Cacheable(cacheNames = "user", key = "'user:' + #uid")
    @Override
    public USER selectByPrimaryKey(Integer uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

    @CacheEvict(cacheNames = {"user", "userList"}, allEntries = true, beforeInvocation = true)
    @Override
    public void deleteByPrimaryKey(Integer uid) {
        userMapper.deleteByPrimaryKey(uid);
    }

    @CacheEvict(cacheNames = {"user", "userList"}, allEntries = true, beforeInvocation = true)
    //@CachePut(cacheNames = "user", key = "'user:' + #user.uid")
    @Override
    public USER updateByPrimaryKeySelective(USER user) {
        userMapper.updateByPrimaryKeySelective(user);
        return user;
    }

    @CacheEvict(cacheNames = {"user", "userList"}, allEntries = true, beforeInvocation = true)
    @Override
    public void insertByPrimaryKeySelective(USER user) {
        userMapper.insertSelective(user);
    }

    @Override
    public void insert(USER user) {
        userMapper.insertSelective(user);
    }


}
