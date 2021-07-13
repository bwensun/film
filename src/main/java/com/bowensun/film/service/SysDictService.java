package com.bowensun.film.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bowensun.film.domain.entity.SysDictEntity;
import com.bowensun.film.domain.vo.DictVo;

import java.util.List;
import java.util.Map;

/**
 * 字典服务
 *
 * @author 郑建雄
 * @date 2021/4/24
 */
public interface SysDictService extends IService<SysDictEntity> {

    /**
     * 初始化字典
     */
    void initDict();

    /**
     * 获取全量字典
     * @return 全量字典
     */
    List<DictVo> getAllDict();

    /**
     * 获取指定字典分类下字典项
     *
     * @return 指定字典分类下字典项
     * @param categoryCode 字典分类
     */
    Map<String, String> getDictInfo(String categoryCode);
}
