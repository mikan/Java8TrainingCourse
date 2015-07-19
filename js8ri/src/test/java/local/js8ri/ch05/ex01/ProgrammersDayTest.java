/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch05.ex01;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author mikan
 */
public class ProgrammersDayTest {

    @Test
    public void testYetAnotherCalc1_equality() {
        assertEquals(ProgrammersDay.calc(2014), ProgrammersDay.yetAnotherCalc1(2014)); // non-leap
        assertEquals(ProgrammersDay.calc(2016), ProgrammersDay.yetAnotherCalc1(2016)); // leap
    }

    @Test
    public void testYetAnotherCalc2_equality() {
        assertEquals(ProgrammersDay.calc(2014), ProgrammersDay.yetAnotherCalc2(2014)); // non-leap
        assertEquals(ProgrammersDay.calc(2016), ProgrammersDay.yetAnotherCalc2(2016)); // leap
    }

    @Test
    public void testCalcByJavaUtilCalendar_equality() {
        assertEquals(ProgrammersDay.calc(2014), ProgrammersDay.calcByJavaUtilCalendar(2014)); // non-leap
        assertEquals(ProgrammersDay.calc(2016), ProgrammersDay.calcByJavaUtilCalendar(2016)); // leap
    }
}