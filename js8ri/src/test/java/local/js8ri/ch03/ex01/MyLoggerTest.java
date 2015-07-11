/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex01;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.logging.Level;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author mikan
 */
public class MyLoggerTest {

    private static final MyLogger SUT = new MyLogger("test", null);

    @BeforeClass
    public static void prepare() {
        SUT.setLevel(Level.ALL);
    }

    @Test(expected = NullPointerException.class)
    public void testLogIf_conditionNPE() {
        SUT.logIf(Level.SEVERE, null, () -> "test NG");
    }

    @Test
    public void testLogIf_normalCase() {
        assertTrue(SUT.logIf(Level.INFO, () -> true, () -> "test OK"));
    }

    @Test
    public void testLogIf_notLoggableCase() {
        assertFalse(SUT.logIf(Level.SEVERE, () -> false, () -> "test NG"));
    }
}
