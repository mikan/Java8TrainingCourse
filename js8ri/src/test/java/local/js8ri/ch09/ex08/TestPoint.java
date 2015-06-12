/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch09.ex08;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Test for Point.
 *
 * @author mikan
 */
public class TestPoint {

    @Test
    public void testCompareTo_normalCase() {
        Point p1 = new Point(5, 5);
        Point p2 = new Point(1, 1);
        assertTrue(p1.compareTo(p2) > 0);
    }

    @Test
    public void testCompareTo_overflowCase() {
        Point p1 = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Point p2 = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);
        assertTrue(p1.compareTo(p2) > 0);
    }

    @Test
    public void testUnsafeCompareTo_overflowCase() {
        Point p1 = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Point p2 = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);
        assertFalse(p1.unsafeCompareTo(p2) > 0); // FALSE!!
    }

    @Test
    public void testSafeCompareTo_overflowCase() {
        Point p1 = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Point p2 = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);
        assertTrue(p1.safeCompareTo(p2) > 0);
    }
}
