package com.bowensun.film.service.impl;

import com.baiwang.customize.generator.util.PageUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bowensun.film.domain.dto.FilmDTO;
import com.bowensun.film.domain.entity.FilmEntity;
import com.bowensun.film.domain.vo.FilmVo;
import com.bowensun.film.repository.FilmMapper;
import com.bowensun.film.service.FilmService;
import com.bowensun.film.service.mapstruct.FilmConverter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 电影服务实现
 *
 * @author 郑建雄
 * @date 2021/4/24
 */
@Service
public class FilmServiceImpl extends ServiceImpl<FilmMapper, FilmEntity> implements FilmService {

    @Resource
    private FilmConverter filmConverter;

    @Override
    public IPage<FilmVo> selectPage(FilmDTO film) {
        FilmEntity filmEntity = filmConverter.dto2Po(film);
        IPage<FilmEntity> page = PageUtils.getPage(film);
        IPage<FilmEntity> result = lambdaQuery().setEntity(filmEntity).page(page);
        return PageUtils.convert(result, filmConverter::po2Vo);
    }
}
