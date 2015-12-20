/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch05.ex07;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author mikan
 */
public class TimeIntervalTest {

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_IAE() {
        LocalDateTime begin = LocalDateTime.of(2015, 1, 1, 0, 0);
        new TimeInterval(begin, begin.minusMinutes(1));
    }

    @Test
    public void testCross_nullInput() {
        LocalDateTime begin = LocalDateTime.of(2015, 1, 1, 0, 0);
        TimeInterval int1 = new TimeInterval(begin, begin.plusDays(1));
        assertFalse(int1.cross(null));
    }

    @Test
    public void testCross_noCrossInput() {
        LocalDateTime begin = LocalDateTime.of(2015, 1, 1, 0, 0);
        TimeInterval int1 = new TimeInterval(begin, begin.plusDays(1));
        TimeInterval int2 = new TimeInterval(begin.plusDays(2), begin.plusDays(3));
        assertFalse(int1.cross(int2));
        assertFalse(int2.cross(int1));
    }

    @Test
    public void testCross_crossInput() {
        LocalDateTime begin = LocalDateTime.of(2015, 1, 1, 0, 0);
        TimeInterval int1 = new TimeInterval(begin, begin.plusDays(1));
        TimeInterval int2 = new TimeInterval(begin, begin.plusDays(2));
        assertTrue(int1.cross(int1));
        assertTrue(int2.cross(int2));
        assertTrue(int1.cross(int2));
        assertTrue(int2.cross(int1));
    }
}
