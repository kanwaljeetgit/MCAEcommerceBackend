package com.lpu.ecommerce.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author KANWALJEET on 31-01-2024
 * @project ecommerce
 **/
class DateTimeUtilsTest {

    @Test
    void isDateTimeEqualOrAfter() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowPlus2Hours = now.plusHours(2);
        assertTrue(DateTimeUtils.isDateTimeEqualOrAfter(nowPlus2Hours,now),StringUtils.format("{} is not after {}",nowPlus2Hours,now));
        assertTrue(DateTimeUtils.isDateTimeEqualOrAfter(now,now),StringUtils.format("{} is not equal {}",now,now));
    }

    @Test
    void isNotDateTimeEqualOrAfter() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowMinus2Hours = now.minusHours(2);
        assertFalse(DateTimeUtils.isDateTimeEqualOrAfter(nowMinus2Hours,now),StringUtils.format("{} is not before {}",nowMinus2Hours,now));
    }

    @Test
    void isDateTimeEqual() {
        LocalDateTime now = LocalDateTime.now();
        assertTrue(DateTimeUtils.isDateTimeEqual(now, now),StringUtils.format("{} is not equal to {}",now, now));
    }

    @Test
    void isDateTimeNotEqual() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowPlus2Hours = now.plusHours(2);
        assertFalse(DateTimeUtils.isDateTimeEqual(nowPlus2Hours, now),StringUtils.format("{} is equal to {}",nowPlus2Hours, now));
    }

    @Test
    void isDateTimeEqualOrBefore() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowMinus2Hours = now.minusHours(2);
        assertTrue(DateTimeUtils.isDateTimeEqualOrBefore(nowMinus2Hours,now),StringUtils.format("{} is not before {}",nowMinus2Hours,now));
        assertTrue(DateTimeUtils.isDateTimeEqualOrBefore(now,now),StringUtils.format("{} is not equal {}",now,now));
    }

    @Test
    void isNotDateTimeEqualOrBefore() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowPlus2Hours = now.plusHours(2);
        assertFalse(DateTimeUtils.isDateTimeEqualOrBefore(nowPlus2Hours,now),StringUtils.format("{} is not after {}",nowPlus2Hours,now));
    }

}