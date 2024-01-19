package com.lpu.ecommerce.utils;

import java.time.LocalDateTime;

/**
 * @author KANWALJEET on 19-01-2024
 * @project ecommerce
 **/
public class DateTimeUtils {

    private DateTimeUtils() throws IllegalAccessException {
        throw new IllegalAccessException("you can not create an object of utility class");
    }

    public static boolean isDateTimeEqualOrAfter(LocalDateTime compare, LocalDateTime compareTo) {
        return isDateTimeEqual(compare,compareTo) || compare.isAfter(compareTo);
    }

    public static boolean isDateTimeEqual(LocalDateTime compare, LocalDateTime compareTo) {
        return compare.isEqual(compareTo);
    }

    public static boolean isDateTimeEqualOrBefore(LocalDateTime compare, LocalDateTime compareTo) {
        return isDateTimeEqual(compare,compareTo) || compare.isBefore(compareTo);
    }

    public static void main(String[] args) {
        LocalDateTime a = LocalDateTime.now();
        LocalDateTime b = LocalDateTime.now().plusHours(2);
        System.out.println(isDateTimeEqualOrAfter(b,a));
    }

}
