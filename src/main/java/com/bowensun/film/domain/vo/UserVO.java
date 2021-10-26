package com.bowensun.film.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baiwang.customize.generator.entity.ExcelIndex;
import lombok.*;

/**
 * 用户对象 user
 * 视图对象
 *
 * @author baiwang
 * @date 2021-04-16
 */
@ToString(callSuper = true)
@Getter
@Setter
public class UserVO extends ExcelIndex{

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    @ExcelProperty(value = "用户名", index = 1)
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 活跃度
     */
    private Long activity;

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
}
