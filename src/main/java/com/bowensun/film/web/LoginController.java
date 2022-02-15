package com.bowensun.film.web;

import com.bowensun.film.domain.base.Result;
import com.bowensun.film.domain.dto.LoginDTO;
import com.bowensun.film.domain.dto.UserRegisterDTO;
import com.bowensun.film.service.LoginService;
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
@Api(value = "BwInvoiceController", tags = "百望开票服务")
public class LoginController {

    @Resource
    private LoginService loginService;

    @ApiOperation(value = "用户登录", tags = "/login")
    @PostMapping("login")
    public Result<String> login(@RequestBody LoginDTO login) {
        String token = loginService.login(login.getUsername(), login.getPassword());
        return Result.success(token);
    }

    @ApiOperation(value = "退出登录", tags = "/logout")
    @DeleteMapping("logout")
    public Result<String> logout() {
        return Result.success("用户退出成功");
    }

    @ApiOperation(value = "用户注册", tags = "/register")
    @PostMapping("register")
    public Result<?> register(@RequestBody @Validated({UserRegisterDTO.Register.class}) UserRegisterDTO user) {
        String token = loginService.register(user);
        return Result.success(token);
    }
}
