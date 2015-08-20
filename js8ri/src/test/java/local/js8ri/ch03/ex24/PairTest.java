/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex24;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author mikan
 */
public class PairTest {

    @Test
    public void testFlatMap_normalInput() {
        Pair<String> input = new Pair<>("first", "second");
        Pair<Integer> output = input.flatMap(t -> new Pair<>(t.length(), 0));
        assertEquals("first".length(), (int) output.getKey());
        assertEquals(0, (int) output.getValue());
    }

    @Test(expected = NullPointerException.class)
    public void testFlatMap_NPE() {
        new Pair<>(1, 2).flatMap(null);
    }
}
