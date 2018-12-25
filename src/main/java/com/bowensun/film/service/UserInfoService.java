package com.bowensun.film.service;

import com.bowensun.film.domain.UserInfo;

import java.util.List;

/**
 * description
 *
 * @author bowensun
 * @date 2018/11/9
 */
public interface UserInfoService {

    void userAdd(UserInfo user);


    List<UserInfo> selectUserInfoList();
}
