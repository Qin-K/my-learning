package com.qin_kai.java8.ch12_dateapi;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * 操纵、解析和格式化日期
 *
 * @author qinkai
 * @date 2021/8/23
 */
public class Ch2_OperateParseAndFormatDate {

    public static void main(String[] args) {
        ch12_2_0();
        ch12_2_1();
    }

    /**
     * TemporalAdjuster
     * 比如，将日期调整到下个周日、下个工作日，或者是本月的最后一天
     */
    private static void ch12_2_1() {
        LocalDate date = LocalDate.of(2020, 1, 1);
        LocalDate date1 = date.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        System.out.println("下一个周日为：" + date1);
    }

    private static void ch12_2_0() {
        // 通过with开头的方法，修改指定的字段，会创建对象的副本不会修改原来的对象
        LocalDate date = LocalDate.of(2020, 1, 1);
        System.out.println(date);
        LocalDate date1 = date.withYear(2021);
        System.out.println(date1);
        LocalDate date2 = date1.withMonth(Month.MAY.getValue());
        System.out.println(date2);
        LocalDate date3 = date2.withDayOfMonth(20);
        System.out.println(date3);
        LocalDate date4 = date3.with(ChronoField.DAY_OF_MONTH, 30);
        System.out.println(date4);

        // 将对的方式修改
        LocalDate date5 = date4.plusWeeks(1);
        System.out.println(date5);
        LocalDate date6 = date5.plus(6, ChronoUnit.MONTHS);
        System.out.println(date6);
    }

}
