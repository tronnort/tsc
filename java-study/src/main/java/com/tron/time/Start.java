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

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime ofLocalDateTime = LocalDateTime.of(localDate,localTime);
        System.out.println(ofLocalDateTime);

        String localDateFormat = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(localDateFormat);

        String localTimeFormat = localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(localTimeFormat);

        String localDateTimeFormat = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(localDateTimeFormat);

        //------------------parse--------------

        LocalDate parseLocalDate = LocalDate.parse(localDateFormat);
        System.out.println(parseLocalDate);

        LocalTime parseLocalTime = LocalTime.parse(localTimeFormat);
        System.out.println(parseLocalTime);

        LocalDateTime parseLocalDateTime = LocalDateTime.parse(localDateTimeFormat,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(parseLocalDateTime);
        System.out.println(parseLocalDateTime.getDayOfMonth());
        System.out.println(parseLocalDateTime.getDayOfWeek());
        System.out.println(parseLocalDateTime.getDayOfYear());
        System.out.println(parseLocalDateTime.getYear());


        //
        Timestamp timestamp = Timestamp.valueOf(localDateTimeFormat);
        System.out.println(timestamp.getTime());

        //
        Instant instant = Instant.now();
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //
        long second = localDateTime.toEpochSecond(ZoneOffset.MAX);
        System.out.println(second);

        Instant toInstant = localDateTime.toInstant(ZoneOffset.ofHours(8));
        Timestamp from = Timestamp.from(toInstant);
        System.out.println(from);
        System.out.println(toInstant.toEpochMilli());

    }
}
