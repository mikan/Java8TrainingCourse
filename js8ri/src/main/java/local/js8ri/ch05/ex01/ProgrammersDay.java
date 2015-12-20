/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch05.ex01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Calendar;

/**
 * Calculate the programmer's day (256th day of year).
 *
 * @author mikan
 */
public class ProgrammersDay {

    private ProgrammersDay() {
        // static use only
    }

    // calc by plusDays
    public static LocalDate calc(int year) {
        return LocalDate.of(year, Month.JANUARY, 1).plusDays(255);
    }

    // calc by ofYearDay
    public static LocalDate yetAnotherCalc1(int year) {
        return LocalDate.ofYearDay(year, 256);
    }

    // calc by minusDays
    public static LocalDate yetAnotherCalc2(int year) {
        LocalDate end = LocalDate.of(year, Month.DECEMBER, 31);
        return end.minusDays((end.isLeapYear() ? 366 : 365) - 256);
    }

    // calc by JUC
    public static LocalDate calcByJavaUtilCalendar(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, Calendar.JANUARY, 256);
        return LocalDateTime.ofInstant(cal.toInstant(), ZoneId.systemDefault()).toLocalDate();
    }
}
