package com.bowensun.film.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bowensun.film.domain.entity.ResourceEntity;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

/**
 * 资源权限Mapper接口
 *
 * @author baiwang
 * @date 2021-04-21
 */
@Repository
public interface ResourceMapper extends BaseMapper<ResourceEntity> {

    /**
     * 获取权限集合
     *
     * @param userId 用户主键
     * @return 权限集合
     */
    HashSet<String> getPermsSet(Long userId);
}
