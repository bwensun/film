package com.bowensun.film.domain.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 字典项VO
 *
 * @author 郑建雄
 * @date 2021/7/13
 */
@Getter
@Setter
@ToString(callSuper = true)
public class DictInfoVo {

    /**
     * 字典项值
     */
    private String dictCode;

    /**
     * 字典项解释
     */
    private String dictDesc;

}
