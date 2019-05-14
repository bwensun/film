package com.bowensun.film.repository;

import com.bowensun.film.domain.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
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
    @Select("select * from user_info where username = #{userName}")
    UserInfo selectByUserName(@Param("userName") String userName);

    //新增用户
    @Insert("insert into user_info(name, password, salt, state, username) values(#{user.uid}, #{user.password}, #{user.salt}, #{user.state}, #{user.username})")
    void userAdd(@Param("user") UserInfo user);

    /**
     * 查询所有用户
     */
    @Select("select * from user_info")
    List<UserInfo> selectUserInfoList();


}
