package com.bowensun.film.common.excel.handler;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.*;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.metadata.property.*;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 描述
 *
 * @author 郑建雄
 * @date 2021/2/25
 */
@Getter
@Setter
public class CustomExcelWriterProperties {

    private Class<?> clazz;

    private RowHeightProperty headRowHeightProperty;

    private RowHeightProperty contentRowHeightProperty;

    private Map<Integer, ExcelContentProperty> contentPropertyMap;

    private Map<Integer, Head> headMap;

    public CustomExcelWriterProperties(Class<?> clazz) {
        this.clazz = clazz;
        this.headRowHeightProperty = RowHeightProperty.build(clazz.getAnnotation(HeadRowHeight.class));
        this.contentRowHeightProperty = RowHeightProperty.build(clazz.getAnnotation(ContentRowHeight.class));

        ExcelProperty excelProperty = clazz.getAnnotation(ExcelProperty.class);


        ColumnWidth parentColumnWidth = (ColumnWidth) clazz.getAnnotation(ColumnWidth.class);
        HeadStyle parentHeadStyle = (HeadStyle) clazz.getAnnotation(HeadStyle.class);
        HeadFontStyle parentHeadFontStyle = (HeadFontStyle) clazz.getAnnotation(HeadFontStyle.class);
        ContentStyle parentContentStyle = (ContentStyle) clazz.getAnnotation(ContentStyle.class);
        ContentFontStyle parentContentFontStyle = (ContentFontStyle) clazz.getAnnotation(ContentFontStyle.class);

        for (Map.Entry<Integer, ExcelContentProperty> entry : getContentPropertyMap().entrySet()) {
            Integer index = entry.getKey();
            ExcelContentProperty excelContentPropertyData = entry.getValue();
            if (excelContentPropertyData == null) {
                throw new IllegalArgumentException(
                        "Passing in the class and list the head, the two must be the same size.");
            }
            Field field = excelContentPropertyData.getField();
            Head headData = getHeadMap().get(index);
            ColumnWidth columnWidth = field.getAnnotation(ColumnWidth.class);
            if (columnWidth == null) {
                columnWidth = parentColumnWidth;
            }
            headData.setColumnWidthProperty(ColumnWidthProperty.build(columnWidth));

            HeadStyle headStyle = field.getAnnotation(HeadStyle.class);
            if (headStyle == null) {
                headStyle = parentHeadStyle;
            }
            headData.setHeadStyleProperty(StyleProperty.build(headStyle));

            HeadFontStyle headFontStyle = field.getAnnotation(HeadFontStyle.class);
            if (headFontStyle == null) {
                headFontStyle = parentHeadFontStyle;
            }
            headData.setHeadFontProperty(FontProperty.build(headFontStyle));

            ContentStyle contentStyle = field.getAnnotation(ContentStyle.class);
            if (contentStyle == null) {
                contentStyle = parentContentStyle;
            }
            headData.setContentStyleProperty(StyleProperty.build(contentStyle));

            ContentFontStyle contentFontStyle = field.getAnnotation(ContentFontStyle.class);
            if (contentFontStyle == null) {
                contentFontStyle = parentContentFontStyle;
            }
            headData.setContentFontProperty(FontProperty.build(contentFontStyle));

            headData.setLoopMergeProperty(LoopMergeProperty.build(field.getAnnotation(ContentLoopMerge.class)));
        }
    }


}
