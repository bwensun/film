package com.bowensun.film.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bowensun.film.domain.entity.UserRoleEntity;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

/**
 * 用户角色关系Mapper接口
 *
 * @author baiwang
 * @date 2021-04-21
 */
@Repository
public interface UserRoleMapper extends BaseMapper<UserRoleEntity> {
}
