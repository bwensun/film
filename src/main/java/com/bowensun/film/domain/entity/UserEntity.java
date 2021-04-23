package com.bowensun.film.domain.entity;

import com.baiwang.customize.generator.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

/**
 * 用户对象 user <br/>
 * 数据库实体对象
 * 
 * @author baiwang
 * @date 2021-04-16
 */
@ToString(callSuper = true)
@Getter
@Setter
@TableName("user")
public class UserEntity extends BaseEntity<Long> {


    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话号码
     */
    private String phoneNumber;

    /**
     * 用户状态
     */
    private Integer status;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 为了去除备注字段
     */
    @TableField(exist = false)
    private String remark;

}