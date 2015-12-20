/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch05.ex06;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mikan
 */
public class BadFridays {

    private BadFridays() {
        // static use only
    }

    @NonNull
    public static List<LocalDate> calcBadFridays(int century) {
        List<LocalDate> badFridays = new ArrayList<>();
        LocalDate day = LocalDate.ofYearDay((century - 1) * 100 + 1, 13);
        while (day.isBefore(LocalDate.ofYearDay(century * 100 + 1, 1))) {
            if (day.getDayOfWeek() == DayOfWeek.FRIDAY) {
                badFridays.add(day);
            }
            day = day.plusMonths(1);
        }
        return badFridays;
    }
}
