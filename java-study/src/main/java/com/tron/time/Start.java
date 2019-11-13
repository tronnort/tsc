package com.tron.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

        String localTimeFormat = localTime.format(DateTimeFormatter.ofPattern("hh:mm:ss"));
        System.out.println(localTimeFormat);

        String localDateTimeFormat = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        System.out.println(localDateTimeFormat);

        //------------------parse--------------

        LocalDate parseLocalDate = LocalDate.parse(localDateFormat);
        System.out.println(parseLocalDate);

        LocalTime parseLocalTime = LocalTime.parse(localTimeFormat);
        System.out.println(parseLocalTime);

        LocalDateTime parseLocalDateTime = LocalDateTime.parse(localDateTimeFormat,DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(parseLocalDateTime);


    }
}
