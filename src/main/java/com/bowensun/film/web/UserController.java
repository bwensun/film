package com.bowensun.film.web;

import com.bowensun.film.domain.base.Result;
import com.bowensun.film.domain.vo.UserVO;
import com.bowensun.film.service.UserService;
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
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("activity/rank")
    public Result<List<UserVO>> activityRank(Integer count){
        List<UserVO> data = userService.activityRank(count);
        return Result.success(data);
    }

    @GetMapping("userInfo")
    public Result<UserVO> userInfo(String token){
        UserVO data = userService.getUserInfo(token);
        return Result.success(data);
    }
}