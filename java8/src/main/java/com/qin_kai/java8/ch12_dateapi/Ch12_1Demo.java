package com.qin_kai.java8.ch12_dateapi;

import java.time.*;
import java.time.temporal.ChronoField;

/**
 * @author qinkai
 * @date 2021/8/23
 */
public class Ch12_1Demo {

    public static void main(String[] args) {
//        ch12_1_1();
//        ch12_1_2();
//        ch12_1_3();
        ch12_1_4();
    }


    /**
     * Duration/Period
     * Duration两个LocalDateTime, LocalTime，Instant之间的时长
     * Period是一年月日为单位的间隔时间
     */
    private static void ch12_1_4() {
        LocalDateTime dt1 = LocalDateTime.of(2020, 1, 1, 12, 0, 0);
        LocalDateTime dt2 = LocalDateTime.of(2020, 1, 1, 13, 0, 0);
        Duration d1 = Duration.between(dt1, dt2);
        System.out.println(d1.getSeconds());

        LocalTime time1 = LocalTime.of(12, 1, 1);
        LocalTime time2 = LocalTime.of(13, 1, 1);
        Duration d2 = Duration.between(time1, time2);
        System.out.println(d2.getSeconds());

        Instant instant1 = Instant.ofEpochSecond(10);
        Instant instant2 = Instant.ofEpochSecond(20);
        Duration d3 = Duration.between(instant1, instant2);
        System.out.println(d3.getSeconds());

        System.out.println();
        LocalDate date1 = LocalDate.of(2008, 5, 12);
        LocalDate date2 = LocalDate.now();
        Period period = Period.between(date1, date2);
        System.out.println(period.getYears() + "年" + period.getMonths() + "月" + period.getDays() + "日");

    }

    /**
     * Instant机器的日期与时间格式
     */
    private static void ch12_1_3() {
        Instant instant = Instant.ofEpochSecond(3);
        instant = Instant.ofEpochSecond(3, 0);
        Instant.ofEpochSecond(2, 1_000_000_000);
        Instant.ofEpochSecond(4, -1_000_000_000);
        Instant now = Instant.now();
//        int day = now.get(ChronoField.DAY_OF_MONTH); UnsupportedTemporalTypeException
//        System.out.println(day);
    }

    /**
     * 合并日期和时间LocalDateTime
     */
    private static void ch12_1_2() {
        LocalDateTime dt1 = LocalDateTime.of(2020, Month.MARCH, 18, 13, 45, 20);

        LocalDate date = LocalDate.of(2020, 12, 1);
        LocalTime time = LocalTime.of(12, 11, 10);
        LocalDateTime dt2 = LocalDateTime.of(date, time);

        LocalDateTime dt3 = date.atTime(12, 11, 12);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);
    }

    /**
     * 使用LocalDate和LocalTime
     */
    private static void ch12_1_1() {
        LocalDate date = LocalDate.of(2021, 8, 20);
        int year = date.getYear();
        System.out.println("year " + year);
        Month month = date.getMonth();
        System.out.println("Month " + month);
        System.out.println("month " + month.getValue());
        int day = date.getDayOfMonth();
        System.out.println("day of month " + day);
        DayOfWeek dow = date.getDayOfWeek();
        System.out.println("DayOfWeek " + dow);
        System.out.println("day of week " + dow.getValue());
        int len = date.lengthOfMonth();
        System.out.println(month.getValue() + " has " + len + " days");
        boolean leapYear = date.isLeapYear();
        System.out.println(year + " is leap year ? " + leapYear);
        LocalDate today = LocalDate.now();
        System.out.println(today);

        System.out.println();

        // 通过get方法传入ChronoField获取指定值，类似Calendar的使用
        int y = date.get(ChronoField.YEAR);
        System.out.println("year " + y);
        int m = date.get(ChronoField.MONTH_OF_YEAR);
        System.out.println("month " + m);

        System.out.println();

        // LocalTime

        LocalTime time = LocalTime.of(12, 0, 0);
        int hour = time.getHour();
        System.out.println("hour " + hour);
        int minute = time.getMinute();
        System.out.println("minute " + minute);
        int second = time.getSecond();
        System.out.println("second " + second);

        // LocalDate LocalTime解析
        LocalDate localDate = LocalDate.parse("2020-12-12");
        System.out.println(localDate);
        LocalTime localTime = LocalTime.parse("12:00:00");
        System.out.println(localTime);
    }

}
