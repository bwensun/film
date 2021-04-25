package com.bowensun.film.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bowensun.film.common.annotation.LogT;
import com.bowensun.film.domain.base.Result;
import com.bowensun.film.domain.dto.FilmDTO;
import com.bowensun.film.domain.vo.FilmVo;
import com.bowensun.film.service.FilmService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 电影控制器
 *
 * @author 郑建雄
 * @date 2021/4/24
 */
@RestController
public class FilmController {

    @Resource
    private FilmService filmService;

    @LogT(functionName = "电影列表分页查询")
    @PostMapping("film/page")
    public Result<IPage<FilmVo>> page(@RequestBody FilmDTO film){
        IPage<FilmVo> data = filmService.selectPage(film);
        return Result.success(data);
    }
}
