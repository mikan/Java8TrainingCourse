/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch02.ex11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author mikan
 */
public class ParallelCollectTest {

    @Test(expected = NullPointerException.class)
    public void testCollect_NPE() {
        ParallelCollect.collect(null, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCollect_IAE() {
        ParallelCollect.collect(Stream.empty(), -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCollect_sequentialInput() {
        ParallelCollect.collect(IntStream.range(0, 1).boxed(), 1);
    }

    @Test
    public void testCollect_emptyInput() {
        Stream<String> input = Stream.empty();
        ArrayList<String> list = ParallelCollect.collect(input.parallel(), 0);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testCollect_normalInput() {
        int sizeOfInput = 100;
        String prefix = "test";
        Stream<String> input = IntStream.range(0, sizeOfInput).mapToObj(i -> prefix + i).parallel();
        ArrayList<String> list = ParallelCollect.collect(input, sizeOfInput);
        assertEquals(sizeOfInput, list.size());
        assertThat(list, everyItem(startsWith(prefix)));
    }
}
