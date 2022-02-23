package com.bowensun.film.service;

import com.bowensun.film.domain.vo.UserVO;

import java.util.List;

/**
 * 排行服务
 *
 * @author bwensun
 * @date 2022/2/23
 */
public interface RankService {

    /**
     * 用户活跃度排行
     *
     * @param count 前几名
     * @return 用户信息
     */
    List<UserVO> activityRank(Integer count);
}
