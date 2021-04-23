package com.bowensun.film.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bowensun.film.domain.dto.ResourceDTO;
import com.bowensun.film.domain.vo.ResourceVO;

import java.util.HashSet;
import java.util.List;

/**
 * 资源权限Service接口
 * 
 * @author baiwang
 * @date 2021-04-21
 */
public interface ResourceService {

    /**
     * 查询资源权限
     *
     * @param id 资源权限ID
     * @return 资源权限
     */
     ResourceVO selectById(Long id);

    /**
     * 查询资源权限列表
     *
     * @param resource 资源权限
     * @return 资源权限集合
     */
    List<ResourceVO> selectList(ResourceDTO resource);

    /**
     * 分页查询资源权限列表
     *
     * @param resource 资源权限
     * @return 资源权限分页对象
     */
    IPage<ResourceVO> selectPaging(ResourceDTO resource);

    /**
     * 新增资源权限
     *
     * @param resource 资源权限
     * @return 结果
     */
    int insert(ResourceDTO resource);

    /**
     * 修改资源权限
     *
     * @param resource 资源权限
     * @return 结果
     */
    int update(ResourceDTO resource);

    /**
     * 批量删除资源权限
     *
     * @param ids 需要删除的资源权限ID
     * @return 结果
     */
    int deleteByIds(Long[] ids);

    /**
     * 删除资源权限信息
     *
     * @param id 资源权限ID
     * @return 结果
     */
    int deleteById(Long id);

    /**
     * 根据userId获取权限集合
     *
     * @param userId 用户主键
     * @return 权限集合
     */
    HashSet<String> getPermsSet(Long userId);
}
