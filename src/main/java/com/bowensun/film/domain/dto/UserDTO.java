package com.bowensun.film.domain.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.baomidou.mybatisplus.annotation.TableName;
import com.bowensun.film.domain.base.Page;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;
import java.util.Date;


/**
 * 用户实体
 *
 * @date 2020-12-26
 * @author 郑建雄
 */
@Getter
@Setter
public class UserDTO extends Page {

    /**
     * 主键
     */
    private Integer uid;

    /**
     * 姓名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 状态
     */
    private Byte state;

    /**
     * 用户名
     */
    private String username;

    /**
     * 生日
     */
    private Date birthday;


    /**
     * 创建时间
     */
    private Date createTime;

}