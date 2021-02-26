package com.bowensun.film.web;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bowensun.film.common.excel.handler.DefaultCellStyleStrategy;
import com.bowensun.film.common.excel.handler.DefaultColumnWidthStrategy;
import com.bowensun.film.common.excel.handler.DefaultWriteHandler;
import com.bowensun.film.common.util.ExcelUtil;
import com.bowensun.film.domain.UserPO;
import com.bowensun.film.domain.dto.UserDTO;
import com.bowensun.film.domain.vo.UserVO;
import com.bowensun.film.service.UserService;
import com.bowensun.film.common.aop.log.LogT;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    @LogT
    @GetMapping(value = "/page")
    public Page<UserPO> selectPage(@RequestBody UserDTO user) {
        return userService.selectPage(user);
    }

    @LogT
    @GetMapping(value = "/list")
    public List<UserVO> selectList(@RequestBody UserDTO user) {
        return userService.selectList(user);
    }

    @LogT
    @PostMapping(value = "/export")
    @SneakyThrows
    public void export(@RequestBody UserDTO user, HttpServletResponse response){
        List<UserVO> userVOList = userService.selectList(user);
        ExcelUtil.prepareExport(response, "用户列表");
        EasyExcel.write(response.getOutputStream(), UserVO.class)
                .useDefaultStyle(false)
                .sheet("用户列表")
                //.registerWriteHandler(new DefaultCellStyleStrategy())
                //.registerWriteHandler(new DefaultColumnWidthStrategy())
                .registerWriteHandler(new DefaultWriteHandler())
                .doWrite(userVOList);
    }

    @LogT
    @PostMapping(value = "/templateExport")
    public void templateExport(HttpServletResponse response) throws IOException {

    }


}