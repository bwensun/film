package com.bowensun.film.domain.dto;

import com.baiwang.customize.generator.IPageParam;
import com.baiwang.customize.generator.dto.PageDTO;
import java.util.Date;
import lombok.*;

/**
 * 资源权限对象 resource <br/>
 * 数据传输对象 <br/>
 * <b>PageDTO 并不是必须的，为了解耦提供了 IPageParam 接口</b>
 * 
 * @author baiwang
 * @date 2021-04-21
 */
@ToString(callSuper = true)
@Getter
@Setter
public class ResourceDTO extends PageDTO implements IPageParam{


    /**
     * 主键
     */
    private Long id;

    /**
     * 菜单名称
     */
    private String resourceName;

    /**
     * 父菜单ID
     */
    private Long parentId;

    /**
     * 显示顺序
     */
    private Integer orderNum;

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
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

}