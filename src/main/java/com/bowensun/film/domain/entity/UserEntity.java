package com.bowensun.film.domain.entity;

import com.baiwang.customize.generator.entity.BaseEntity;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 用户对象 user <br/>
 * 数据库实体对象
 * 
 * @author baiwang
 * @date 2021-04-16
 */
@ToString(callSuper = true)
@Getter
@Setter
@TableName("user")
public class UserEntity extends BaseEntity {


    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
