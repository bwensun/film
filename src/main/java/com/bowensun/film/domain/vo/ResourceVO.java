package com.bowensun.film.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baiwang.customize.generator.entity.ExcelIndex;
import lombok.*;

/**
 * 资源权限对象 resource
 * 视图对象
 *
 * @author baiwang
 * @date 2021-04-21
 */
@ToString(callSuper = true)
@Getter
@Setter
public class ResourceVO extends ExcelIndex{

    /**
     * 菜单名称
     */
    @ExcelProperty(value = "菜单名称", index = 1)
    private String resourceName;


    /**
     * 父菜单ID
     */
    @ExcelProperty(value = "父菜单ID", index = 2)
    private Long parentId;


    /**
     * 显示顺序
     */
    @ExcelProperty(value = "显示顺序", index = 3)
    private Integer orderNum;


    /**
     * 路由地址
     */
    @ExcelProperty(value = "路由地址", index = 4)
    private String path;


    /**
     * 组件路径
     */
    @ExcelProperty(value = "组件路径", index = 5)
    private String component;


    /**
     * 是否为外链（0是 1否）
     */
    @ExcelProperty(value = "是否为外链（0是 1否）", index = 6)
    private Integer isFrame;


    /**
     * 是否缓存（0缓存 1不缓存）
     */
    @ExcelProperty(value = "是否缓存（0缓存 1不缓存）", index = 7)
    private Integer isCache;


    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    @ExcelProperty(value = "菜单类型（M目录 C菜单 F按钮）", index = 8)
    private String menuType;


    /**
     * 菜单状态（0显示 1隐藏）
     */
    @ExcelProperty(value = "菜单状态（0显示 1隐藏）", index = 9)
    private String visible;


    /**
     * 菜单状态（0正常 1停用）
     */
    @ExcelProperty(value = "菜单状态（0正常 1停用）", index = 10)
    private String status;


    /**
     * 权限标识
     */
    @ExcelProperty(value = "权限标识", index = 11)
    private String perms;


    /**
     * 菜单图标
     */
    @ExcelProperty(value = "菜单图标", index = 12)
    private String icon;


    /**
     * 备注
     */
    @ExcelProperty(value = "备注", index = 13)
    private String remark;

}
