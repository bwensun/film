package com.bowensun.film.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baiwang.customize.generator.entity.ExcelIndex;
import lombok.*;

/**
 * 角色对象 role
 * 视图对象
 *
 * @author baiwang
 * @date 2021-04-16
 */
@ToString(callSuper = true)
@Getter
@Setter
public class RoleVO extends ExcelIndex{

    /**
     * 角色名
     */
    @ExcelProperty(value = "角色名", index = 1)
    private String roleName;


    /**
     * 描述
     */
    @ExcelProperty(value = "描述", index = 2)
    private String desc;

}
