package com.bowensun.film.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.bowensun.film.domain.base.BaseEntity;
import lombok.*;

/**
 * 角色对象 role <br/>
 * 数据库实体对象
 * 
 * @author baiwang
 * @date 2021-04-16
 */
@ToString(callSuper = true)
@Getter
@Setter
@TableName("role")
public class RoleEntity extends BaseEntity {

    /**
     * 主键
     */
    private Long id;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 描述
     */
    @TableField(value = "`desc`")
    private String desc;
}
