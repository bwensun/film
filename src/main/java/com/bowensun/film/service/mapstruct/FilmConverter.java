package com.bowensun.film.service.mapstruct;

import com.bowensun.film.domain.dto.FilmDTO;
import com.bowensun.film.domain.entity.FilmEntity;
import com.bowensun.film.domain.vo.FilmVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 电影
 *
 * @author 郑建雄
 * @date 2021/4/25
 */
@Component
@Mapper(componentModel = "spring")
public interface FilmConverter {

    /**
     * dto2Po
     *
     * @param dto FilmDTO
     * @return FilmEntity
     */
    FilmEntity dto2Po(FilmDTO dto);

    /**
     * po2Vo
     *
     * @param records records
     * @return List<FilmVo>
     */
    List<FilmVo> poList2VoList(List<FilmEntity> records);


    /**
     * po2Vo
     *
     * @param dto FilmDTO
     * @return FilmEntity
     */
    FilmVo po2Vo(FilmEntity dto);
}
