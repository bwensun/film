package com.bowensun.film.domain.base;

import lombok.Getter;
import lombok.Setter;

/**
 * 分页对象
 *
 * @author 郑建雄
 * @date 2020/12/26
 */
@Getter
@Setter
public class Page {

    /**
     * 页码
     */
    protected Integer pageNumber;

    /**
     * 页数
     */
    protected Integer pageSize;
}
