package com.bowensun.film.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;


/**
 * 用户实体
 *
 * @date 2020-12-26
 * @author 郑建雄
 */
@Getter
@Setter
@TableName("user")
public class UserPO {

    /**
     * 主键
     */
    @TableId
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
     * 测试时间
     */
    private Date testDate;

    /**
     * 创建时间
     */
    private Date createTime;

}