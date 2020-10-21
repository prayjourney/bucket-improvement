package com.zgy.learn.crud.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Author: renjiaxin
 * @Description:
 * @Date: 2019-11-25 12:51
 * @Modified by:
 */
@Component
public class DateConversionService implements Converter<String, LocalDate> {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public LocalDate convert(String birthday) {
        System.out.println("=====================1111111=!");
        // 處理的格式都是2019-11-11這種，對於2019-2-12，2019-12-1則無法處理, 解決後2種問題
        String[] s = birthday.split("-");
        if (s[1].length() == 1) {
            s[1] = "0" + s[1];
        }
        if (s[2].length() == 1) {
            s[2] = "0" + s[2];
        }
        String newBirthday = s[0] + "-" + s[1] + "-" + s[2];
        System.out.println("完成了轉換！");
        return LocalDate.parse(newBirthday, formatter);
    }
}