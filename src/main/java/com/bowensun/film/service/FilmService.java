package com.bowensun.film.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bowensun.film.domain.dto.FilmDTO;
import com.bowensun.film.domain.entity.FilmEntity;
import com.bowensun.film.domain.vo.FilmVo;

/**
 * 电影服务
 *
 * @author 郑建雄
 * @date 2021/4/24
 */
public interface FilmService extends IService<FilmEntity> {

    /**
     * 电影分页
     *
     * @param film 电影
     * @return 分页对象
     */
    IPage<FilmVo> selectPage(FilmDTO film);
}
