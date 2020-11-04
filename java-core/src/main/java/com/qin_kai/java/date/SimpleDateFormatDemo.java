package com.qin_kai.java.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat用于日期的格式化和解析字符串
 *
 * @author qinkai
 * @date 2020/11/4
 */
public class SimpleDateFormatDemo {
    public static void main(String[] args) throws ParseException {
        Date d = new Date();
        System.out.println(d.toLocaleString());

        // 默认的格式化
        SimpleDateFormat sdf1 = new SimpleDateFormat();
        String s1 = sdf1.format(d);
        // 20-11-4 上午9:36
        System.out.println(s1);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s2 = sdf2.format(d);
        System.out.println(s2);

        // 字符串解析成日期
        Date d1 = sdf1.parse("2018/8/8 下午2:08");
        System.out.println(d1.toLocaleString());

        Date d2 = sdf2.parse("2018年08月08日 14:11:38");
        System.out.println(d2.toLocaleString());
    }
}
