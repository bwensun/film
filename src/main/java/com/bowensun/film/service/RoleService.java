package com.bowensun.film.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bowensun.film.domain.dto.RoleDTO;
import com.bowensun.film.domain.vo.RoleVO;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 角色Service接口
 * 
 * @author baiwang
 * @date 2021-04-16
 */
public interface RoleService {

    /**
     * 查询角色
     *
     * @param id 角色ID
     * @return 角色
     */
     RoleVO selectById(Long id);

    /**
     * 查询角色列表
     *
     * @param role 角色
     * @return 角色集合
     */
    List<RoleVO> selectList(RoleDTO role);

    /**
     * 分页查询角色列表
     *
     * @param role 角色
     * @return 角色分页对象
     */
    IPage<RoleVO> selectPaging(RoleDTO role);

    /**
     * 新增角色
     *
     * @param role 角色
     * @return 结果
     */
    int insert(RoleDTO role);

    /**
     * 修改角色
     *
     * @param role 角色
     * @return 结果
     */
    int update(RoleDTO role);

    /**
     * 批量删除角色
     *
     * @param ids 需要删除的角色ID
     * @return 结果
     */
    int deleteByIds(Long[] ids);

    /**
     * 删除角色信息
     *
     * @param id 角色ID
     * @return 结果
     */
    int deleteById(Long id);

    /**
     * 给用户设置角色
     *
     * @param userId 用户主键
     * @param roleName 角色名
     */
    void setUserRole(Long userId, @NotEmpty String roleName);
}
