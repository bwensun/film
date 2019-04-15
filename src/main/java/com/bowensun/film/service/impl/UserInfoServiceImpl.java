package com.bowensun.film.service.impl;

import com.bowensun.film.domain.UserInfo;
import com.bowensun.film.repository.UserInfoDao;
import com.bowensun.film.service.UserInfoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description
 *
 * @author bowensun
 * @date 2018/11/9
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private ValueOperations valueOperations;

    @Override
    public void userAdd(UserInfo user) {
        userInfoDao.userAdd(user);
    }

    @Override
    @Cacheable
    public List<UserInfo> selectUserInfoList() {
        //ObjectMapper objectMapper = new ObjectMapper();
        //valueOperations.set("userInfoList", userInfos);
        List<UserInfo> userInfos = userInfoDao.selectUserInfoList();
        return  userInfos;
    }
}
