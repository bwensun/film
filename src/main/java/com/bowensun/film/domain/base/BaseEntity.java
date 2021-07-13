package com.bowensun.film.domain.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.time.LocalDateTime;

/**
 * 基类
 *
 * @author 郑建雄
 */
public abstract class BaseEntity {

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

    @TableField(value = "ext1", select = false)
    protected String ext1;

    @TableField(value = "ext2", select = false)
    protected String ext2;

    @TableField(value = "ext3", select = false)
    protected String ext3;

    @TableField(value = "ext4", select = false)
    protected String ext4;


}