package com.bowensun.film.web;

import com.bowensun.film.domain.base.Result;
import com.bowensun.film.domain.vo.UserVO;
import com.bowensun.film.service.UserService;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.*;


/**
 * 用户控制器
 *
 * @author 郑建雄
 * @date 2019/3/18
 */
@RestController
@RequestMapping(value = "user")
@Slf4j
@Api(tags = "用户接口")
@ApiSupport(order = 999)
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("activity/rank")
    @ApiOperation(value = "获取用户活跃度排行")
    public Result<List<UserVO>> activityRank(Integer count){
        List<UserVO> data = userService.activityRank(count);
        return Result.success(data);
    }

    @GetMapping("userInfo")
    @ApiOperation(value = "获取用户详情")
    public Result<UserVO> userInfo(String token){
        UserVO data = userService.getUserInfo(token);
        return Result.success(data);
    }
}