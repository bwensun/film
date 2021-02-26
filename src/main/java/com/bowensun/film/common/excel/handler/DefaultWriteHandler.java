package com.bowensun.film.common.excel.handler;

import com.alibaba.excel.event.Order;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.util.StyleUtil;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.handler.WorkbookWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import com.alibaba.excel.write.metadata.holder.WriteWorkbookHolder;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 默认写入拦截器
 *
 * <p>1. 为导出的每一行增加序号列
 * <p>2. 预设头样式和内容样式
 * <p>  2.1 头字体宋体 14
 * <p>  2.2 内容字体Calibri 12
 * <p>  2.3 表头填充灰色25%
 * <p>3. 固定列宽20
 * @author 郑建雄
 * @date 2021/2/4
 */
@Slf4j
public class DefaultWriteHandler implements CellWriteHandler, WorkbookWriteHandler, Order {

    /**
     * 首行序号
     */
    private AtomicInteger index = new AtomicInteger(1);

    /**
     * 头部样式
     */
    private CellStyle headCellStyle;

    /**
     * 内容样式
     */
    private CellStyle contentCellStyle;

    /**
     * 是否被初始化
     */
    boolean hasInitialized = Boolean.FALSE;

    @Override
    public void beforeWorkbookCreate() {
    }

    @Override
    public void afterWorkbookCreate(WriteWorkbookHolder writeWorkbookHolder) {
        initCellStyle(writeWorkbookHolder.getWorkbook());
        hasInitialized = true;
    }

    @Override
    public void afterWorkbookDispose(WriteWorkbookHolder writeWorkbookHolder) {
    }

    @Override
    public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Head head, Integer integer, Integer integer1, Boolean aBoolean) {

    }

    @Override
    public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell, Head head, Integer integer, Boolean isHead) {

    }

    @Override
    public void afterCellDataConverted(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, CellData cellData, Cell cell, Head head, Integer integer, Boolean isHead) {

    }

    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<CellData> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
        log.trace("【单元格处理后拦截处理】 正在处理第{}行第{}列单元格", cell.getRowIndex(), cell.getColumnIndex());

        // 1.固定列宽20
        setColumnWidth(writeSheetHolder, cell, relativeRowIndex, isHead);


        // 2.设置序号
        if (!isHead && cell.getColumnIndex() == 0) {
            cell.setCellValue(index.getAndIncrement());
        }

        // 3.样式设置
        if (isHead) {
            setHeadCellStyle(cell);
        } else {
            setContentCellStyle(cell);
        }
    }

    /**
     * 固定列宽 20
     *
     * @param writeSheetHolder WriteSheetHolder
     * @param cell 单元格
     * @param relativeRowIndex 行号
     * @param isHead 是否为标题
     */
    private void setColumnWidth(WriteSheetHolder writeSheetHolder, Cell cell, Integer relativeRowIndex, Boolean isHead) {
        boolean needSetWidth = relativeRowIndex != null && (isHead || relativeRowIndex == 0);
        if (!needSetWidth) {
            return;
        }
        int width = 20 * 256;
        writeSheetHolder.getSheet().setColumnWidth(cell.getColumnIndex(), width);
    }


    @Override
    public int order() {
        return Integer.MIN_VALUE;
    }

    /**
     * 设置单元格头样式
     *
     * @param cell 单元格
     */
    protected void setHeadCellStyle(Cell cell) {
        if (headCellStyle == null) {
            return;
        }
        cell.setCellStyle(headCellStyle);
    }

    /**
     * 设置单元格内容样式
     *
     * @param cell 单元格
     */
    protected void setContentCellStyle(Cell cell) {
        if (contentCellStyle == null) {
            return;
        }
        cell.setCellStyle(contentCellStyle);
    }

    /**
     * 初始化单元格
     * 工作簿创建时执行 为了复用
     *
     * @param workbook 工作簿
     */
    private void initCellStyle(Workbook workbook) {
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
}
