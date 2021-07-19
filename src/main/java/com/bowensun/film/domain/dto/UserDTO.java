package com.bowensun.film.domain.dto;

import com.baiwang.customize.generator.IPageParam;
import com.baiwang.customize.generator.dto.PageDTO;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Tolerate;

import javax.validation.constraints.NotEmpty;

/**
 * 用户对象 user <br/>
 * 数据传输对象 <br/>
 * <b>PageDTO 并不是必须的，为了解耦提供了 IPageParam 接口</b>
 * 
 * @author baiwang
 * @date 2021-04-16
 */
@ToString(callSuper = true)
@Getter
@Setter
@Builder
public class UserDTO extends PageDTO implements IPageParam{


    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空", groups = Insert.class)
    private String username;

    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空", groups = Insert.class)
    private String password;

    /**
     * 昵称
     */
    @NotEmpty(message = "昵称不能为空", groups = Insert.class)
    private String nickname;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 邮箱
     */
    @NotEmpty(message = "邮箱不能为空", groups = Insert.class)
    private String email;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 活跃度
     */
    private Long activity;

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
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 角色集合
     */
    private List<RoleDTO> roles;

    @Tolerate
    public UserDTO() {
    }

    interface Insert{}

    @JsonIgnore
    public boolean isAdmin() {
        return this.id == 1;
    }
}