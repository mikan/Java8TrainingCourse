/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch09.ex10;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Test LabeledPoint2.
 *
 * @author mikan
 */
public class TestLabeledPoint2 {

    @Test
    public void testCompareTo() {
        LabeledPoint2 five = new LabeledPoint2(5, 5, "five");
        LabeledPoint2 five2 = new LabeledPoint2(5, 5, "five");
        LabeledPoint2 three = new LabeledPoint2(3, 3, "three");
        assertTrue(five.compareTo(five2) == 0);
        assertTrue(five2.compareTo(five) == 0);
        assertTrue(five.compareTo(three) > 0);
        assertTrue(three.compareTo(five) < 0);
    }
}
