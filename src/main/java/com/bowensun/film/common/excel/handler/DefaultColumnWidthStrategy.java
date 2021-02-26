package com.bowensun.film.common.excel.handler;

import com.alibaba.excel.event.Order;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.style.column.AbstractHeadColumnWidthStyleStrategy;

/**
 * 默认的列宽策略
 *
 * @author 郑建雄
 * @date 2021/2/25
 */
public class DefaultColumnWidthStrategy extends AbstractHeadColumnWidthStyleStrategy implements Order {

    @Override
    protected Integer columnWidth(Head head, Integer columnIndex) {
        return 20;
    }

    @Override
    public int order() {
        return Integer.MIN_VALUE;
    }

    @Override
    public String uniqueValue() {
        return "defaultColumnWidthStrategy";
    }
}
