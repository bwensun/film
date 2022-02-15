package com.bowensun.film.web;

import com.bowensun.film.domain.base.Result;
import com.bowensun.film.domain.vo.DictVo;
import com.bowensun.film.service.SysDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
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
@Api(value = "字典", tags = "system")
public class SystemController {

    @Resource
    private SysDictService sysDictService;


    @GetMapping (value = "system/dict/init")
    @ApiOperation(value = "初始化字典", tags = "system/dict/init")
    public Result<?> initDict(){
        sysDictService.initDict();
        return Result.success();
    }

    @GetMapping(value = "system/dict/all")
    @ApiOperation(value = "查询所有字典项", tags = "system/dict/all")
    public Result<List<DictVo>> getAllDict(){
        List<DictVo> data = sysDictService.getAllDict();
        return Result.success(data);
    }

    @PostMapping(value = "system/dict/info")
    @ApiOperation(value = "查询指定字典项", tags = "system/dict/info")
    public Result<Map<String, String>> getDictInfo(@NotEmpty(message = "字典分类项不能为空") String categoryCode){
        Map<String, String> data = sysDictService.getDictInfo(categoryCode);
        return Result.success(data);
    }
}
