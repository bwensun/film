package com.bowensun.film.repository;

import com.bowensun.film.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户接口
 *
 * @author bowensun
 * @date 2018/11/3
 */
@Mapper
@Repository
public interface UserInfoDao {
    //根据用户名查询
    @Cacheable(keyGenerator = "customerKeyGenerator")
    UserInfo selectByUserName(@Param("userName") String userName);

    //新增用户
    void userAdd(@Param("user") UserInfo user);

    //查询所有用户
    List<UserInfo> selectUserInfoList();
}
