package com.bowensun.film.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bowensun.film.domain.entity.LoginInfoEntity;
import org.springframework.stereotype.Repository;

/**
 * 登录记录
 *
 * @author 郑建雄
 * @date 2021/4/25
 */
@Repository
public interface LoginInfoMapper extends BaseMapper<LoginInfoEntity> {
}
