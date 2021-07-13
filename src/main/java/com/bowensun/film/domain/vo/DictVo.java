package com.bowensun.film.domain.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/**
 * 字典展示VO
 *
 * @author 郑建雄
 * @date 2021/7/13
 */
@Getter
@Setter
@ToString(callSuper = true)
public class DictVo {

    /**
     * 字典分类项值
     */
    private String categoryCode;

    /**
     * 该分类下字典项List
     */
    private Map<String, String> dictInfoMap;
}
