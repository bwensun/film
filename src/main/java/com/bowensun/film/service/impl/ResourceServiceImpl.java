package com.bowensun.film.service.impl;

import com.baiwang.customize.generator.util.WrapperUtils;
import com.baiwang.customize.generator.util.DateUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baiwang.customize.generator.util.PageUtils;
import com.bowensun.film.domain.dto.ResourceDTO;
import com.bowensun.film.domain.entity.ResourceEntity;
import com.bowensun.film.domain.vo.ResourceVO;
import com.bowensun.film.repository.ResourceMapper;
import com.bowensun.film.service.ResourceService;
import com.bowensun.film.service.mapstruct.ResourceConverter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 资源权限Service业务层处理
 *
 * @author baiwang
 * @date 2021-04-21
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Resource
    private ResourceMapper mapper;

    @Resource
    private ResourceConverter converter;

    /**
     * 查询资源权限
     *
     * @param id 资源权限ID
     * @return 资源权限
     */
    @Override
    public ResourceVO selectById(Long id) {
        return converter.to(mapper.selectById(id));
    }

    @Override
    public List<ResourceVO> selectList(ResourceDTO dto) {
        List<ResourceEntity> result = mapper.selectList(getQueryWrapper(dto));
        return converter.toList(result);
    }

    @Override
    public IPage<ResourceVO> selectPaging(ResourceDTO dto) {
        IPage<ResourceEntity> page = PageUtils.getPage(dto);
        IPage<ResourceEntity> result = mapper.selectPage(page, getQueryWrapper(dto));
        return PageUtils.convert(result, converter::to);
    }

    @Override
    public int insert(ResourceDTO dto) {
        ResourceEntity entity = converter.from(dto);
        entity.setCreateTime(DateUtils.getNowDate());
        return mapper.insert(entity);
    }

    @Override
    public int update(ResourceDTO dto) {
        ResourceEntity entity = converter.from(dto);
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

    @Override
    public HashSet<String> getPermsSet(Long userId) {
        return mapper.getPermsSet(userId);
    }

    /**
     * 查询语句构造器
     * @param dto 数据传输对象
     * @return 返回一个查询构造器
     */
    private QueryWrapper<ResourceEntity> getQueryWrapper(ResourceDTO dto) {
        return WrapperUtils.<ResourceEntity>of()
            .like("resource_name", dto.getResourceName())
            .end();
    }
}
