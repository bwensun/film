package com.bowensun.film.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.bowensun.film.domain.base.BaseEntityWithoutExt;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 字典类
 *
 * @author 郑建雄
 * @date 2021/7/13
 */
@ToString(callSuper = true)
@Getter
@Setter
@TableName("sys_dict")
public class SysDictEntity extends BaseEntityWithoutExt {

    /**
     * 主键
     */
    private Long id;

    /**
     * 字典项值
     */
    private String dictCode;

    /**
     * 字典项解释
     */
    private String dictDesc;

    /**
     * 字典分类项值
     */
    private String categoryCode;

    /**
     * 字典分类项解释
     */
    private String categoryDesc;

    /**
     * 排序值
     */
    private Integer sortNo;
}
