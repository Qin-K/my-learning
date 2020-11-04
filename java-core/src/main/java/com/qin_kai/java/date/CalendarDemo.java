package com.qin_kai.java.date;

import java.util.Calendar;
import java.util.Date;

/**
 * Calendar 为操作日历字段提供了方法
 *
 * @author qinkai
 * @date 2020/11/4
 */
public class CalendarDemo {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();

        // 获取日期
        //  int get(int field)
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)  + 1;// month 默认为0-11表示
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println(year + "年" + month + "月" + day + "日");

        // 设置日期
        // void set(int field, int value) 将给定的日历字段设置为给定值。
        calendar.set(Calendar.YEAR, 1998);
        year = calendar.get(Calendar.YEAR);
        System.out.println(year);

        // 修改日期
        // add(int field, int amount) 根据日历的规则，为给定的日历字段添加或减去指定的时间量。
        calendar.add(Calendar.YEAR, 1);
        year = calendar.get(Calendar.YEAR);
        System.out.println(year);

        // 获取 calendar 对应的 date
        Date date = calendar.getTime();
        System.out.println(date);
    }

}

