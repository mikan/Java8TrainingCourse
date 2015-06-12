/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch09.ex09;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Test LabeledPoint.
 *
 * @author mikan
 */
public class TestLabeldedPoint {

    @Test
    public void testEquals() {
        LabeledPoint five = new LabeledPoint(5, 5, "five");
        LabeledPoint five2 = new LabeledPoint(5, 5, "five");
        LabeledPoint three = new LabeledPoint(3, 3, "three");
        assertTrue(five.equals(five2));
        assertTrue(five2.equals(five));
        assertFalse(five.equals(three));
        assertTrue(five.hashCode() == five2.hashCode());
        assertTrue(five.hashCode() != three.hashCode());
    }
}
