package com.bowensun.film.service.impl;

import com.baiwang.customize.generator.util.WrapperUtils;
import com.baiwang.customize.generator.util.DateUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baiwang.customize.generator.util.PageUtils;
import com.bowensun.film.domain.dto.RoleDTO;
import com.bowensun.film.domain.entity.RoleEntity;
import com.bowensun.film.domain.vo.RoleVO;
import com.bowensun.film.repository.RoleMapper;
import com.bowensun.film.service.RoleService;
import com.bowensun.film.service.mapstruct.RoleConverter;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 角色Service业务层处理
 *
 * @author baiwang
 * @date 2021-04-16
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper mapper;

    @Resource
    private RoleConverter converter;

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
        entity.setCreateTime(DateUtils.getNowDate());
        return mapper.insert(entity);
    }

    @Override
    public int update(RoleDTO dto) {
        RoleEntity entity = converter.from(dto);
        entity.setUpdateTime(DateUtils.getNowDate());
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
