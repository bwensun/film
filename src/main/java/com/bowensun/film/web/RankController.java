package com.bowensun.film.web;

import com.bowensun.film.domain.base.Result;
import com.bowensun.film.domain.vo.UserVO;
import com.bowensun.film.service.RankService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 排行控制器
 *
 * @author bwensun
 * @date 2022/2/23
 */
@RestController
public class RankController {

    @Resource
    private RankService rankService;

    @GetMapping("rank/activity")
    @ApiOperation(value = "获取用户活跃度排行")
    public Result<List<UserVO>> activityRank(Integer count) {
        List<UserVO> data = rankService.activityRank(count);
        return Result.success(data);
    }
}
