package com.bowensun.film.service.impl;

import com.baiwang.customize.generator.util.WrapperUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baiwang.customize.generator.util.PageUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bowensun.film.common.constant.ExceptionEnum;
import com.bowensun.film.common.exception.BizException;
import com.bowensun.film.domain.dto.RoleDTO;
import com.bowensun.film.domain.entity.RoleEntity;
import com.bowensun.film.domain.entity.SysDictEntity;
import com.bowensun.film.domain.entity.UserRoleEntity;
import com.bowensun.film.domain.vo.RoleVO;
import com.bowensun.film.repository.RoleMapper;
import com.bowensun.film.repository.SysDictMapper;
import com.bowensun.film.repository.UserRoleMapper;
import com.bowensun.film.service.RoleService;
import com.bowensun.film.service.mapstruct.RoleConverter;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
import java.util.Arrays;
import java.util.List;

/**
 * 角色Service业务层处理
 *
 * @author baiwang
 * @date 2021-04-16
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements RoleService {

    @Resource
    private RoleMapper mapper;

    @Resource
    private RoleConverter converter;

    @Resource
    private UserRoleMapper userRoleMapper;

    /**
     * 查询角色
     *
     * @param id 角色ID
     * @return 角色
     */
    @Override
    public RoleVO selectById(Long id) {
        return converter.to(mapper.selectById(id));
    }

    @Override
    public List<RoleVO> selectList(RoleDTO dto) {
        List<RoleEntity> result = mapper.selectList(getQueryWrapper(dto));
        return converter.toList(result);
    }

    @Override
    public IPage<RoleVO> selectPaging(RoleDTO dto) {
        IPage<RoleEntity> page = PageUtils.getPage(dto);
        IPage<RoleEntity> result = mapper.selectPage(page, getQueryWrapper(dto));
        return PageUtils.convert(result, converter::to);
    }

    @Override
    public int insert(RoleDTO dto) {
        RoleEntity entity = converter.from(dto);
        return mapper.insert(entity);
    }

    @Override
    public int update(RoleDTO dto) {
        RoleEntity entity = converter.from(dto);
        return mapper.updateById(entity);
    }

    @Override
    public int deleteByIds(Long[] ids) {
        return mapper.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteById(id);
    }

    /**
     * 授予基础角色
     *
     * @param userId 用户主键
     */
    @Override
    public void setUserRole(Long userId, @NotEmpty String roleName){
        Long roleId = this.lambdaQuery()
                .eq(RoleEntity::getRoleName, roleName)
                .list()
                .stream()
                .findFirst()
                .orElseThrow(() -> BizException.of(ExceptionEnum.INTERNAL_ERROR.code, "未初始化权限"))
                .getId();
        UserRoleEntity userRoleEntity = new UserRoleEntity()
                .setUserId(userId)
                .setRoleId(roleId);
        userRoleMapper.insert(userRoleEntity);
    }

    /**
     * 查询语句构造器
     * @param dto 数据传输对象
     * @return 返回一个查询构造器
     */
    private QueryWrapper<RoleEntity> getQueryWrapper(RoleDTO dto) {
        return WrapperUtils.<RoleEntity>of()
            .like("role_name", dto.getRoleName())
            .end();
    }
}
