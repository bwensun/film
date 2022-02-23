package com.bowensun.film.web;

import com.bowensun.film.domain.base.Result;
import com.bowensun.film.domain.dto.UserDTO;
import com.bowensun.film.domain.vo.UserVO;
import com.bowensun.film.service.UserService;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 用户控制器
 *
 * @author 郑建雄
 * @date 2019/3/18
 */
@RestController
@Slf4j
@Api(tags = "用户接口")
@ApiSupport(order = 999)
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("user/{id}")
    @ApiOperation(value = "获取用户详情")
    public Result<UserVO> userInfo(@PathVariable Long id) {
        UserVO data = userService.getUserInfo(id);
        return Result.success(data);
    }

    @ApiOperation(value = "用户信息更新")
    @PatchMapping("user/{id}")
    public Result<?> update(@PathVariable Long id, @RequestBody UserDTO user) {
        user.setId(id);
        userService.update(user);
        return Result.success();
    }
}