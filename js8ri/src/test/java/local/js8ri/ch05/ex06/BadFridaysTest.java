/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch05.ex06;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author mikan
 */
public class BadFridaysTest {

    @Test
    public void testCalcBadFridays_20thCentury() {
        List<LocalDate> result = BadFridays.calcBadFridays(20);
        assertFalse(result.isEmpty());
        result.forEach(date -> {
            assertEquals(13, date.getDayOfMonth());
            assertEquals(DayOfWeek.FRIDAY, date.getDayOfWeek());
        });
    }

    @Test
    public void testCalcBadFridays_21thCentury() {
        List<LocalDate> result = BadFridays.calcBadFridays(21);
        assertFalse(result.isEmpty());
        result.forEach(date -> {
            assertEquals(13, date.getDayOfMonth());
            assertEquals(DayOfWeek.FRIDAY, date.getDayOfWeek());
        });
    }
}
