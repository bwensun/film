package com.bowensun.film.domain.dto;

import lombok.Data;

/**
 * 用户登陆传输对象
 *
 * @author 郑建雄
 * @date 2021/5/8
 */
@Data
public class LoginDTO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
