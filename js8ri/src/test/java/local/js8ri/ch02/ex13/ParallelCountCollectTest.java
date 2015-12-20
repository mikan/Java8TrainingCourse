/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch02.ex13;

import org.junit.Test;

import java.util.stream.Stream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * @author mikan
 */
public class ParallelCountCollectTest {

    @Test(expected = NullPointerException.class)
    public void testCountShortWords_NPE() {
        ParallelCountCollect.countShortWords(null, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCountShortWords_IAE() {
        ParallelCountCollect.countShortWords(Stream.empty(), -1);
    }

    @Test
    public void testCountShortWords_emptyInput() {
        int threshold = 5;
        int[] result = ParallelCountCollect.countShortWords(Stream.empty(), threshold);
        assertThat(result, is(new int[]{0, 0, 0, 0, 0}));
    }

    @Test
    public void testCountShortWords_simpleInput() {
        int threshold = 5;
        int[] result = ParallelCountCollect.countShortWords(Stream.iterate("A", s -> s + "A").limit(threshold + 1), threshold);
        assertEquals(threshold, result.length);
        assertThat(result, is(new int[]{0, 1, 1, 1, 1}));
    }

    @Test
    public void testCountShortWords_normalInput() {
        int threshold = 5;
        int[] result = ParallelCountCollect.countShortWords(Stream.of("N", "C", "C", "1701", "ENTERPRISE"), threshold);
        assertEquals(threshold, result.length);
        assertThat(result, is(new int[]{0, 3, 0, 0, 1}));
    }
}
