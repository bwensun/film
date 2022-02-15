package com.bowensun.film.web;

import com.bowensun.film.domain.base.Result;
import com.bowensun.film.domain.dto.LoginDTO;
import com.bowensun.film.domain.dto.UserRegisterDTO;
import com.bowensun.film.service.LoginService;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 登陆控制器
 *
 * @author 郑建雄
 * @date 2021/4/20
 */
@RestController
@Api(tags = "基本服务接口")
@ApiSupport(order = 0)
public class LoginController {

    @Resource
    private LoginService loginService;

    @ApiOperation(value = "用户登录")
    @PostMapping("login")
    public Result<String> login(@RequestBody LoginDTO login) {
        String token = loginService.login(login.getUsername(), login.getPassword());
        return Result.success(token);
    }

    @ApiOperation(value = "退出登录")
    @DeleteMapping("logout")
    public Result<String> logout() {
        return Result.success("用户退出成功");
    }

    @ApiOperation(value = "用户注册")
    @PostMapping("register")
    public Result<?> register(@RequestBody @Validated({UserRegisterDTO.Register.class}) UserRegisterDTO user) {
        String token = loginService.register(user);
        return Result.success(token);
    }
}
