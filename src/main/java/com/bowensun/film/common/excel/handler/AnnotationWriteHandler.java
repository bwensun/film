package com.bowensun.film.common.excel.handler;

import com.alibaba.excel.event.Order;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.handler.WriteHandler;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.AbstractVerticalCellStyleStrategy;
import com.alibaba.excel.write.style.column.AbstractHeadColumnWidthStyleStrategy;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 注解样式解析
 *
 * @author 郑建雄
 * @date 2021/2/23
 */
@Slf4j
public class AnnotationWriteHandler {

    private CustomExcelWriterProperties writerProperties;

    boolean hasColumnWidth;
    boolean hasStyle;

    public AnnotationWriteHandler(Class<?> clazz) {
        //1. 获取headMap
        writerProperties = new CustomExcelWriterProperties(clazz);
        //2. initAnnotationConfig
        initAnnotationConfig();
    }

    protected void initAnnotationConfig() {
        Map<Integer, Head> headMap = writerProperties.getHeadMap();
        for (Head head : headMap.values()) {
            if (head.getColumnWidthProperty() != null) {
                hasColumnWidth = true;
            }
            if (head.getHeadStyleProperty() != null || head.getHeadFontProperty() != null
                    || head.getContentStyleProperty() != null || head.getContentFontProperty() != null) {
                hasStyle = true;
            }
        }
    }

    public ExcelWriterBuilder register(ExcelWriterBuilder self){
        //注册行宽拦截器
        //self.registerWriteHandler(dealColumnWidth());
        //注册样式拦截器
        self.registerWriteHandler(dealStyle());
        //注册行高拦截器
        return self;
    }

    private AbstractVerticalCellStyleStrategy dealStyle() {
        if (!hasColumnWidth){
            log.error("未添加样式相关注解到导出类，无法注册样式拦截器！");
            return null;
        }
        return new AnnoColumnStrategy();
    }

    private WriteHandler dealColumnWidth() {
        if (!hasColumnWidth){
            log.error("未添加行相关注解到导出类，无法注册行宽拦截器！");
            return null;
        }
        return new AbstractHeadColumnWidthStyleStrategy() {
            @Override
            protected Integer columnWidth(Head head, Integer columnIndex) {
                if (head == null) {
                    return null;
                }
                if (head.getColumnWidthProperty() != null) {
                    return head.getColumnWidthProperty().getWidth();
                }
                return null;
            }
        };
    }

    private static class AnnoColumnStrategy extends AbstractVerticalCellStyleStrategy implements Order {

        @Override
        protected WriteCellStyle headCellStyle(Head head) {
            return WriteCellStyle.build(head.getHeadStyleProperty(), head.getHeadFontProperty());
        }

        @Override
        protected WriteCellStyle contentCellStyle(Head head) {
            return WriteCellStyle.build(head.getContentStyleProperty(), head.getContentFontProperty());
        }

        @Override
        public int order() {
            return 1;
        }
    }
}
