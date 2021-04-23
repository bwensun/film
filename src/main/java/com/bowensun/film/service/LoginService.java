package com.bowensun.film.service;

/**
 * 登录服务
 *
 * @author 郑建雄
 * @date 2021/4/20
 */
public interface LoginService {

    /**
     * 登录服务
     *
     * @param username 用户名
     * @param password 密码
     *
     * @return token
     */
    String login(String username, String password);
}
