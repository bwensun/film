package com.bowensun.film.domain.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 电影实体
 *
 * @author 郑建雄
 * @date 2021/4/25
 */
@ToString(callSuper = true)
@Getter
@Setter
public class FilmVo {

    /**
     * 主键
     */
    private Long id;

    /**
     * 电影名
     */
    private String filmName;

    /**
     * 导演
     */
    private String director;

    /**
     * 上映地点
     */
    private String screenLocation;

    /**
     * 上映时间
     */
    private String screenDate;

    /**
     * 封面海报地址
     */
    private String cover;

    /**
     * 介绍
     */
    private String introduction;
}
