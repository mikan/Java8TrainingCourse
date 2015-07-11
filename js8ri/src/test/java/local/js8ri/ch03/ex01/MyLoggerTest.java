/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex01;

import org.junit.Test;

import java.util.logging.Level;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author mikan
 */
public class MyLoggerTest {

    private static final MyLogger SUT = new MyLogger("test", null);

    @Test(expected = NullPointerException.class)
    public void testLogIf_conditionNPE() {
        SUT.logIf(Level.OFF, null, () -> "test");
    }

    @Test
    public void testLogIf_normalCase() {
        SUT.setLevel(Level.ALL);
        assertTrue(SUT.logIf(Level.INFO, () -> true, () -> "test"));
    }

    @Test
    public void testLogIf_notLoggableCase() {
        SUT.setLevel(Level.ALL);
        assertFalse(SUT.logIf(Level.INFO, () -> false, () -> "test"));
    }
}
