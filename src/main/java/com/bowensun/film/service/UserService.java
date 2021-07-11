package com.bowensun.film.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bowensun.film.domain.dto.UserDTO;
import com.bowensun.film.domain.entity.UserEntity;
import com.bowensun.film.domain.vo.UserVO;

import java.util.List;

/**
 * 用户Service接口
 * 
 * @author baiwang
 * @date 2021-04-16
 */
public interface UserService extends IService<UserEntity> {

    /**
     * 查询用户
     *
     * @param id 用户ID
     * @return 用户
     */
     UserVO selectById(Long id);

    /**
     * 查询用户列表
     *
     * @param user 用户
     * @return 用户集合
     */
    List<UserVO> selectList(UserDTO user);

    /**
     * 分页查询用户列表
     *
     * @param user 用户
     * @return 用户分页对象
     */
    IPage<UserVO> selectPaging(UserDTO user);

    /**
     * 新增用户
     *
     * @param user 用户
     * @return 结果
     */
    int insert(UserDTO user);

    /**
     * 修改用户
     *
     * @param user 用户
     * @return 结果
     */
    int update(UserDTO user);

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的用户ID
     * @return 结果
     */
    int deleteByIds(Long[] ids);

    /**
     * 删除用户信息
     *
     * @param id 用户ID
     * @return 结果
     */
    int deleteById(Long id);

    /**
     * 根据用户名获取UserDTO
     *
     * @param username 用户名
     * @return UserDTO
     */
    UserDTO getUserDtoByUsername(String username);

    /**
     * 用户活跃度调整
     *
     * @param userId 用户主键
     * @param delta 偏移量
     */
    void activityAdjust(Long userId, double delta);
}
