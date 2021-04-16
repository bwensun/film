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
     * 用户名
     */
    @ExcelProperty(value = "用户名", index = 1)
    private String username;


    /**
     * 密码
     */
    @ExcelProperty(value = "密码", index = 2)
    private String password;

}
