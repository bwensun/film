package com.bowensun.film.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.bowensun.film.common.config.redis.RedisCache;
import com.bowensun.film.common.constant.BizConstant;
import com.bowensun.film.domain.vo.UserVO;
import com.bowensun.film.service.RankService;
import com.bowensun.film.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 排行服务
 *
 * @author bwensun
 * @date 2022/2/23
 */
@Service
public class RankServiceImpl implements RankService {

    @Resource
    private UserService userService;

    @Resource
    private RedisCache redisCache;


    @Override
    public List<UserVO> activityRank(Integer count) {
        Set<Integer> userIdSet = redisCache.revRange(BizConstant.ACTIVITY_RANK_KEY, 0, count - 1);
        List<UserVO> userVOList = new ArrayList<>();
        if (CollUtil.isNotEmpty(userIdSet)) {
            userIdSet.forEach(id -> {
                UserVO userVO = userService.selectById(id.longValue());
                userVOList.add(userVO);
            });
        }
        return userVOList;
    }
}
