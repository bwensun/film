package com.bowensun.film.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户角色关系实体
 *
 * @author 郑建雄
 * @date 2021/7/19
 */
@Getter
@Setter
@ToString
@TableName("user_role")
public class UserRoleEntity {

    /**
     * 用户主键
     */
    private Long userId;

    /**
     * 角色主键
     */
    private Long roleId;
}
