package com.bowensun.film.service.impl;

import com.bowensun.film.domain.USER;
import com.bowensun.film.repository.USERMapper;
import com.bowensun.film.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private USERMapper userMapper;

    @Override
    public List<USER> selectUserInfoList() {
        return null;
    }

    @Cacheable(cacheNames = "userList", key = "'userList:'+#pageNumber+'_'+#pageSize")
    @Override
    public List<USER> selectUserInfoList(Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return userMapper.selectByExample().build().execute();
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
}
