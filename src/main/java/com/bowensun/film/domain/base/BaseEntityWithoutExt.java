package com.bowensun.film.domain.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.time.LocalDateTime;

/**
 * 不带扩展字段的基类
 *
 * @author 郑建雄
 * @date 2021/7/13
 */
public abstract class BaseEntityWithoutExt {

    @TableField(
            value = "create_by",
            fill = FieldFill.INSERT,
            select = false
    )
    protected String createBy;

    @TableField(
            value = "create_time",
            fill = FieldFill.INSERT,
            select = false
    )
    protected LocalDateTime createTime;

    @TableField(
            value = "update_by",
            fill = FieldFill.INSERT_UPDATE,
            select = false
    )
    protected String updateBy;

    @TableField(
            value = "update_time",
            fill = FieldFill.INSERT_UPDATE,
            select = false
    )
    protected LocalDateTime updateTime;
}
