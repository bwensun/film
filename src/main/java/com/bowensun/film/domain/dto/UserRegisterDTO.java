package com.bowensun.film.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

/**
 * 用户注册实体
 *
 * @author 郑建雄
 * @date 2021/7/19
 */
@ToString
@Getter
@Setter
public class UserRegisterDTO {

    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空", groups = Register.class)
    private String username;

    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空", groups = Register.class)
    private String password;

    /**
     * 昵称
     */
    @NotEmpty(message = "昵称不能为空", groups = Register.class)
    private String nickname;

    /**
     * 邮箱
     */
    @NotEmpty(message = "邮箱不能为空", groups = Register.class)
    private String email;

    /**
     * 验证码
     */
    @NotEmpty(message = "验证码不能为空", groups = Register.class)
    private String captcha;
    
    public interface Register{}
}
