package com.bowensun.film.web;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bowensun.film.common.annotation.LogT;
import com.bowensun.film.common.excel.handler.DefaultWriteHandler;
import com.bowensun.film.common.util.ExcelUtil;
import com.bowensun.film.domain.dto.UserDTO;
import com.bowensun.film.domain.vo.UserVO;
import com.bowensun.film.service.UserService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
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

    @LogT(functionName = "测试： 用户分页查询")
    @GetMapping(value = "/page")
    public IPage<UserVO> selectPage(@RequestBody UserDTO user) {
        return userService.selectPaging(user);
    }

    @LogT(functionName = "测试： 用户List查询")
    @GetMapping(value = "/list")
    public List<UserVO> selectList(@RequestBody UserDTO user) {
        return userService.selectList(user);
    }

    @LogT(functionName = "测试： export")
    @PostMapping(value = "/export")
    @SneakyThrows
    public void export(@RequestBody UserDTO user, HttpServletResponse response){
        List<UserVO> userVOList = userService.selectList(user);
        ExcelUtil.prepareExport(response, "用户列表");
        EasyExcel.write(response.getOutputStream(), UserVO.class)
                .useDefaultStyle(false)
                .sheet("用户列表")
                .registerWriteHandler(new DefaultWriteHandler())
                .doWrite(userVOList);
    }
}