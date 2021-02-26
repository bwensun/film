package com.bowensun.film.domain.base;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 导出序号
 *
 * @author 郑建雄
 * @date 2021/2/5
 */
@Getter
@Setter
@ToString
public class ExcelIndex {

    @ExcelProperty(value = "序号", index = 0)
    @ColumnWidth(10)
    private Long index;
}
