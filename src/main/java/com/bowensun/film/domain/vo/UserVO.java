package com.bowensun.film.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.*;
import com.bowensun.film.common.excel.converter.ExcelDateConverter;
import com.bowensun.film.domain.base.ExcelIndex;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;

import java.util.Date;


/**
 * 用户实体
 *
 * @date 2020-12-26
 * @author 郑建雄
 */
@Getter
@Setter
@ToString(callSuper = true)
public class UserVO extends ExcelIndex {


    /**
     * 姓名
     */
    @ExcelProperty(value = "姓名", index = 1)
    @HeadFontStyle(color = Font.COLOR_RED)
    private String name;

    /**
     * 密码
     */
    @ExcelProperty(value = "密码", index = 2)
    private String password;

    /**
     * 生日
     */
    @ExcelProperty(value = "生日", index = 3, converter = ExcelDateConverter.class)
    private Date birthday;


    private Integer state;

}