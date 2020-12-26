package com.bowensun.film.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ContentFontStyle;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.annotation.write.style.HeadFontStyle;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import com.bowensun.film.common.excel.converter.ExcelDateConverter;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.usermodel.FillPatternType;

import java.util.Date;


/**
 * 用户实体
 *
 * @date 2020-12-26
 * @author 郑建雄
 */
@Getter
@Setter
public class UserVO {
    /**
     * 姓名
     */
    @ExcelProperty(value = "姓名", index = 0)
    private String name;

    /**
     * 密码
     */
    @ExcelProperty(value = "密码", index = 1)
    private String password;

    /**
     * 生日
     */
    @ExcelProperty(value = "生日", index = 2, converter = ExcelDateConverter.class)
    private Date birthday;

    /**
     * 测试时间
     */
    @DateTimeFormat("yyyy-MM-dd")
    private Date testDate;
}