package com.bowensun.film.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bowensun.film.domain.base.Result;
import com.bowensun.film.domain.dto.FilmDTO;
import com.bowensun.film.domain.vo.FilmVo;
import com.bowensun.film.service.FilmService;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * 电影控制器
 *
 * @author 郑建雄
 * @date 2021/4/24
 */
@RestController
@Api(tags = "电影接口")
@ApiSupport(order = 2)
public class FilmController {

    @Resource
    private FilmService filmService;

    @ApiOperation(value = "电影分页查询")
    @PostMapping("film/page")
    public Result<IPage<FilmVo>> page(@RequestBody FilmDTO film) {
        IPage<FilmVo> data = filmService.selectPage(film);
        return Result.success(data);
    }

    @ApiOperation(value = "电影详情查询")
    @PostMapping("film/{id}")
    public Result<FilmVo> detail(@NotNull(message = "主键不能为空") @PathVariable Long id) {
        FilmVo film = filmService.detail(id);
        return Result.success(film);
    }
}
