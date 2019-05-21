package com.bowensun.film.service;

import com.bowensun.film.domain.USER;

import java.util.List;

/**
 * description
 *
 * @author bowensun
 * @date 2018/11/9
 */
public interface UserService {
    List<USER> selectUserInfoList();

    List<USER> selectUserInfoList(Integer pageNumber, Integer pageSize);

    USER selectByPrimaryKey(Integer uid);

    void deleteByPrimaryKey(Integer uid);

    USER updateByPrimaryKeySelective(USER user);

    void insertByPrimaryKeySelective(USER user);
}
