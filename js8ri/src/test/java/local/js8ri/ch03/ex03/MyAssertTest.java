/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex03;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author mikan
 */
public class MyAssertTest {

    @Test
    public void testAssertTrue_expectedCase() {
        MyAssert.setEnabled(true);
        MyAssert.assertTrue(() -> true);
        assertTrue(true); // junit
    }

    @Test(expected = AssertionError.class)
    public void testAssertTrue_unexpectedCase() {
        MyAssert.setEnabled(true);
        MyAssert.assertTrue(() -> false);
    }

    @Test(expected = AssertionError.class)
    public void testAssertTrue_nullCase() {
        MyAssert.setEnabled(true);
        MyAssert.assertTrue(null);
    }

    @Test()
    public void testAssertFalse_expectedCase() {
        MyAssert.setEnabled(true);
        MyAssert.assertFalse(() -> false);
        assertFalse(false); // junit
    }

    @Test(expected = AssertionError.class)
    public void testAssertFalse_unexpectedCase() {
        MyAssert.setEnabled(true);
        MyAssert.assertFalse(() -> true);
    }

    @Test(expected = AssertionError.class)
    public void testAssertFalse_nullCase() {
        MyAssert.setEnabled(true);
        MyAssert.assertFalse(null);
    }

    @Test
    public void testEquals_expectedCase() {
        MyAssert.setEnabled(true);
        MyAssert.assertEquals(null, null);
        MyAssert.assertEquals(() -> null, () -> null);
        MyAssert.assertEquals(() -> true, () -> true);
        MyAssert.assertEquals(() -> "foo", () -> "foo");
    }

    @Test(expected = AssertionError.class)
    public void testEquals_unexpectedNullAndStringCase() {
        MyAssert.setEnabled(true);
        MyAssert.assertEquals(() -> null, () -> "foo");
    }

    @Test(expected = AssertionError.class)
    public void testEquals_unexpectedStringAndNullCase() {
        MyAssert.setEnabled(true);
        MyAssert.assertEquals(() -> "foo", () -> null);
    }
}
