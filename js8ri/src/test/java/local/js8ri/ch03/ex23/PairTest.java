/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex23;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author mikan
 */
public class PairTest {

    @Test
    public void testMap_normalInput() {
        Pair<String> input = new Pair<>("first", "second");
        Pair<Integer> output = input.map(String::length);
        assertEquals("first".length(), (int) output.getKey());
        assertEquals("second".length(), (int) output.getValue());
    }

    @Test(expected = NullPointerException.class)
    public void testMap_NPE() {
        new Pair<>(1, 2).map(null);
    }
}
