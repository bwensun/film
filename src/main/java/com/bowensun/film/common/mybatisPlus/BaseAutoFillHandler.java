package com.bowensun.film.common.mybatisPlus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

/**
 * 基础自动填充处理
 *
 * @author 郑建雄
 * @date 2021/7/13
 */
@Slf4j
@Component
public class BaseAutoFillHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("【Mybatis-Plus】Insert启用自动填充...");
        //新建默认状态正常
        this.strictInsertFill(metaObject, "status", () -> 1, Integer.class);
        //默认性别未知
        this.strictInsertFill(metaObject, "sex", () -> 2, Integer.class);
        //默认初始等级一级
        this.strictInsertFill(metaObject, "level", () -> 1, Integer.class);
        //默认活跃度0
        this.strictInsertFill(metaObject, "activity", () -> 0.00, Double.class);
        //默认创建人admin
        this.strictInsertFill(metaObject, "createBy", () -> "admin", String.class);
        //默认创建时间当前时间
        this.strictInsertFill(metaObject, "createTime", LocalDateTime::now, LocalDateTime.class);
        //默认创建人admin
        this.strictInsertFill(metaObject, "updateBy", () -> "admin", String.class);
        //默认创建时间当前时间
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("【Mybatis-Plus】Update启用自动填充...");
        //默认创建人admin
        this.strictUpdateFill(metaObject, "updateBy", () -> "admin", String.class);
        //默认创建时间当前时间
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
    }
}
