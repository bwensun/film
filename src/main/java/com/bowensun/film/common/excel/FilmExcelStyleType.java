package com.bowensun.film.common.excel;

import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.excel.entity.params.ExcelForEachParams;
import cn.afterturn.easypoi.excel.export.styler.IExcelExportStyler;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

/**
 * @author 郑建雄
 * @program film
 * @description
 * @date 2019/9/5
 */
public class FilmExcelStyleType implements IExcelExportStyler {

    @Override
    public CellStyle getHeaderStyle(short i) {
        return null;
    }

    @Override
    public CellStyle getTitleStyle(short i) {
        return null;
    }

    /**
     * @param b
     * @param excelExportEntity
     * @deprecated
     */
    @Override
    public CellStyle getStyles(boolean b, ExcelExportEntity excelExportEntity) {
        return null;
    }

    @Override
    public CellStyle getStyles(Cell cell, int i, ExcelExportEntity excelExportEntity, Object o, Object o1) {
        return null;
    }

    @Override
    public CellStyle getTemplateStyles(boolean b, ExcelForEachParams excelForEachParams) {
        return null;
    }
}
