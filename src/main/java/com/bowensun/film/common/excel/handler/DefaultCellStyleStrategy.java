package com.bowensun.film.common.excel.handler;

import com.alibaba.excel.event.Order;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.util.StyleUtil;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.AbstractCellStyleStrategy;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * 默认单元格样式处理策略
 *
 * @author 郑建雄
 * @date 2021/2/22
 */
public class DefaultCellStyleStrategy extends AbstractCellStyleStrategy implements Order {

    private CellStyle headCellStyle;

    private CellStyle contentCellStyle;

    @Override
    protected void initCellStyle(Workbook workbook) {
        //头部样式设置
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        headWriteCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setBold(true);
        headWriteFont.setFontHeightInPoints((short) 14);
        headWriteCellStyle.setWriteFont(headWriteFont);
        headCellStyle = StyleUtil.buildHeadCellStyle(workbook, headWriteCellStyle);

        //内容样式设置
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        WriteFont contentWriteFont = new WriteFont();
        contentWriteFont.setFontHeightInPoints((short) 12);
        contentWriteCellStyle.setWriteFont(contentWriteFont);
        contentCellStyle = StyleUtil.buildContentCellStyle(workbook, contentWriteCellStyle);

    }

    @Override
    protected void setHeadCellStyle(Cell cell, Head head, Integer relativeRowIndex) {
        if (headCellStyle == null) {
            return;
        }
        cell.setCellStyle(headCellStyle);
    }

    @Override
    protected void setContentCellStyle(Cell cell, Head head, Integer relativeRowIndex) {
        if (contentCellStyle == null) {
            return;
        }
        cell.setCellStyle(contentCellStyle);
    }

    @Override
    public int order() {
        return Integer.MIN_VALUE;
    }

    @Override
    public String uniqueValue() {
        return "defaultCellStyleStrategy";
    }
}
