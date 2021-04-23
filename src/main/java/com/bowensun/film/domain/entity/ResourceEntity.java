package com.bowensun.film.domain.entity;

import com.baiwang.customize.generator.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 资源权限对象 resource <br/>
 * 数据库实体对象
 * 
 * @author baiwang
 * @date 2021-04-21
 */
@ToString(callSuper = true)
@Getter
@Setter
@TableName("resource")
public class ResourceEntity extends BaseEntity<Long> {


    /**
     * 主键
     */
    private Long id;

    /**
     * 菜单名称
     */
    private String resourceName;

    /**
     * 路由地址
     */
    private String path;

    /**
     * 组件路径
     */
    private String component;

    /**
     * 是否为外链（0是 1否）
     */
    private Integer isFrame;

    /**
     * 是否缓存（0缓存 1不缓存）
     */
    private Integer isCache;

    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    private String menuType;

    /**
     * 菜单状态（0显示 1隐藏）
     */
    private String visible;

    /**
     * 菜单状态（0正常 1停用）
     */
    private String status;

    /**
     * 权限标识
     */
    private String perms;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 备注
     */
    private String remark;
}
