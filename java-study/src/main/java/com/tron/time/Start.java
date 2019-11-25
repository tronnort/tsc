package com.tron.time;

import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @Description
 * @auther tron
 * @create 2019-11-13
 */
public class Start {
    public static void main(String[] args) {

        //获取当前日期
        LocalDate localDate = LocalDate.now();

        //获取当前时间
        LocalTime localTime = LocalTime.now();

        //获取当前完整时间
        LocalDateTime localDateTime = LocalDateTime.now();

        //通过静态构造方法获取完整时间
        LocalDateTime ofLocalDateTime = LocalDateTime.of(localDate,localTime);

        //格式化日期
        String localDateFormat = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        //格式化时间
        String localTimeFormat = localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        //格式化完整日期时间
        String localDateTimeFormat = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        //格式化完整日期时间带星期
        String localDateTimeFormatPlus = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd E HH:mm:ss"));

        //------------------parse--------------

        //日期字符转对象
        LocalDate parseLocalDate = LocalDate.parse(localDateFormat);

        //时间字符转对象
        LocalTime parseLocalTime = LocalTime.parse(localTimeFormat);

        //时间日期字符转对象
        LocalDateTime parseLocalDateTime = LocalDateTime.parse(localDateTimeFormat,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(parseLocalDateTime.getDayOfMonth());   //获取几号
        System.out.println(parseLocalDateTime.getDayOfWeek());    //获取周几 英文的
        System.out.println(parseLocalDateTime.getDayOfYear());    //年的第几天
        System.out.println(parseLocalDateTime.getYear());       //年


        //日期增加或减少
        LocalDateTime minusDays = parseLocalDateTime.minusDays(1);   //天数减一，其他节点减的方法类似
        LocalDateTime plusDays = parseLocalDateTime.plusDays(10);    //天数加10,能自动调整月份，其他节点加的方法类似


        //判断方法
        int i = minusDays.compareTo(plusDays);         //排序接口
        boolean after = minusDays.isAfter(plusDays);   //判断时间是否在之后
        boolean before = minusDays.isBefore(plusDays);  //判断时间是否在之前
        boolean equal = minusDays.isEqual(plusDays);    //判断时间是否相等


        //指定时间
        LocalDateTime of = LocalDateTime.of(2019, 1, 20, 12, 30);


        //数据库时间
        Timestamp timestamp = Timestamp.valueOf(localDateTimeFormat);

        //时间戳
        Instant instant = Instant.now();
        long milli = instant.toEpochMilli();   //毫秒

        //时间戳到秒
        long second = localDateTime.toEpochSecond(ZoneOffset.MAX);   //秒


        //转时间戳
        Instant zoneInstant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        long l = zoneInstant.toEpochMilli();

        Instant toInstant = localDateTime.toInstant(ZoneOffset.ofHours(8));
        Timestamp from = Timestamp.from(toInstant);

        //时间戳转时期类
        LocalDateTime ofInstant = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());


    }
}
