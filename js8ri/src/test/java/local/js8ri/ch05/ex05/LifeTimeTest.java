/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch05.ex05;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author mikan
 */
public class LifeTimeTest {

    @Test
    public void testCalcLifeDates_invokeOnly() {
        int days = LifeTime.calcLifeDates();
        assertTrue(days > 365 * 27);
        System.out.println(days);
    }
}
