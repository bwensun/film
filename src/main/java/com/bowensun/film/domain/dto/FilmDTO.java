package com.bowensun.film.domain.dto;

import com.baiwang.customize.generator.IPageParam;
import com.baiwang.customize.generator.dto.PageDTO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 电影dto
 *
 * @author 郑建雄
 * @date 2021/4/24
 */
@Getter
@Setter
@TableName("film")
@ToString(callSuper = true)
public class FilmDTO extends PageDTO implements IPageParam {

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

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

}
