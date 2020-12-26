package com.bowensun.film.common.util;

import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.IndexedColors;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Excel工具类
 * 基于EasyExcel 0_0
 *
 * @author 郑建雄
 * @date 2020/12/26
 */
@SuppressWarnings("unused")
public class ExcelUtil {

    /**
     * 导出前准备
     * <p> 1.设置请求头信息，文件名后缀防重，防中文乱码</p>
     * <p> 2.设置编码格式utf-8,contentTyp类型</p>
     *
     * @param response 响应流
     * @param fileName 文件名
     */
    @SneakyThrows
    public static void prepareExport(HttpServletResponse response, String fileName) {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        fileName = URLEncoder.encode(fileName + getFileSuffix(), "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
    }

    /**
     * 自定义导出的默认样式
     *  <p>
     *      默认样式：<br>
     *      1.表头字体宋体 14 <br>
     *      2.内容字体Calibri 12 <br>
     *      3.表头填充灰色25% <br>
     *  </p>
     *
     * @return 样式策略
     */
    public static HorizontalCellStyleStrategy defaultCellStyle() {
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        headWriteCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setBold(true);
        headWriteFont.setFontHeightInPoints((short) 14);
        headWriteCellStyle.setWriteFont(headWriteFont);
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        WriteFont contentWriteFont = new WriteFont();
        contentWriteFont.setFontHeightInPoints((short) 12);
        contentWriteCellStyle.setWriteFont(contentWriteFont);
        return new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
    }

    /**
     * 自定义导出的默认宽度
     * <p>默认宽度20 </>
     *
     * @return 样式策略
     */
    public static SimpleColumnWidthStyleStrategy defaultWidthStyle() {
        return new SimpleColumnWidthStyleStrategy(20);
    }

    private static String getFileSuffix() {
        String now = LocalDate.now().toString().replace("-", "");
        String random = UUID.randomUUID().toString().substring(0, 8);
        return now + random;
    }
}
