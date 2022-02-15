package com.bowensun.film.service.task;

import com.bowensun.film.common.config.redis.RedisCache;
import com.bowensun.film.common.constant.BizConstant;
import com.bowensun.film.domain.entity.UserEntity;
import com.bowensun.film.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;

/**
 * 用户活跃度相关定时任务
 *
 * @author 郑建雄
 * @date 2021/7/11
 */
@Component
@Slf4j
public class UserActivityTask {

    @Resource
    private RedisCache redisCache;

    @Resource
    private UserService userService;

    /**
     * 每周一次重置活跃度
     */
    @Scheduled(cron = "0 0 2 * * SUN")
    @Async
    void reSetUserActivity() {
        log.info("【用户活跃度重置】 每周凌晨两点重置用户活跃度");
        userService.lambdaQuery()
                .select(UserEntity::getId)
                .eq(UserEntity::getStatus, BizConstant.UserStatus.NORMAL)
                .list()
                .stream()
                .map(UserEntity::getId)
                .forEach(id -> redisCache.setSortObject(BizConstant.ACTIVITY_RANK_KEY, id, 0));
    }

    @Scheduled(cron = "0 0 3 * * ?")
    @Async
    void syncUserActivity() {
        log.info("【用户活跃度同步】 每天凌晨一点同步用户活跃度到DB");
        Set<DefaultTypedTuple<Long>> set = redisCache.revRangeWithScores(BizConstant.ACTIVITY_RANK_KEY, 0, 4);
        set.forEach(typedTuple -> userService.lambdaUpdate()
                .set(true, UserEntity::getActivity, typedTuple.getScore())
                .eq(UserEntity::getId, typedTuple.getValue())
                .update());
    }



}
