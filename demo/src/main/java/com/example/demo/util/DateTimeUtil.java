package com.example.demo.util;

import org.joda.time.*;

//tái sử dụng phương thức hoặc có thay đổi gì thì vào đây thay đổi
public class DateTimeUtil {
    //using joda time
    //getCurrentDate without time information
    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    //get time without date
    public static LocalTime getCurrentTime() {
        return LocalTime.now();
    }

    //get current date and time without considerign the time zone
    public static LocalDateTime getDateTime() {
        return LocalDateTime.now();
    }
    //we can convert as below
    //LocalDateTime currentDateAndTime = LocalDateTime.now();
//    DateTime dateTime = currentDateAndTime.toDateTime();
//    LocalDate localDate = currentDateAndTime.toLocalDate();
//    LocalTime localTime = currentDateAndTime.toLocalTime();


    //joda time giúp dễ làm việc với nhiều múi giờ khác nhau va thay đổi giữa chúng
    //sử dụng múi giờ cụ thể cho toàn bộ ứng dụng
    //The default time zone used by Joda-Time is selected from the user.timezone Java system property
    //DateTimeZone.setDefault(DateTimeZone.UTC); UTC mặc định nếu ta ko chỉ định múi giờ
    //xem múi giờ có sẵn: DateTimeZone.getAvailableIDs()


    //using joda  time to get value with UTC timezone
    public static DateTime getValueWithUTC() {
//        LocalDateTime currentDateAndTime = LocalDateTime.now(DateTimeZone.UTC);//Lấy thời gian hiện tại theo time zone UTC
        DateTime dt = new DateTime(DateTimeZone.UTC);////Lấy thời gian hiện tại theo time zone UTC
        return dt;
    }



}


