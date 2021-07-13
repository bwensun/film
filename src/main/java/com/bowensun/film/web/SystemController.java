package com.bowensun.film.web;

import com.bowensun.film.common.annotation.LogT;
import com.bowensun.film.domain.base.Result;
import com.bowensun.film.domain.vo.DictVo;
import com.bowensun.film.service.SysDictService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * 系统控制器
 *
 * @author 郑建雄
 * @date 2021/7/13
 */
@RestController
@Validated
public class SystemController {

    @Resource
    private SysDictService sysDictService;


    @GetMapping (value = "system/dict/init")
    @LogT(functionName = "字典初始化")
    public Result<?> initDict(){
        sysDictService.initDict();
        return Result.success();
    }

    @GetMapping(value = "system/dict/all")
    @LogT(functionName = "获取全量字典")
    public Result<List<DictVo>> getAllDict(){
        List<DictVo> data = sysDictService.getAllDict();
        return Result.success(data);
    }

    @PostMapping(value = "system/dict/info")
    @LogT(functionName = "获取指定分类下字典项")
    public Result<Map<String, String>> getDictInfo(@NotEmpty(message = "字典分类项不能为空") String categoryCode){
        Map<String, String> data = sysDictService.getDictInfo(categoryCode);
        return Result.success(data);
    }
}
