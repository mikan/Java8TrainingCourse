/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch01.ex01;

import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

@RunWith(Theories.class)
public class ArraysSortTest {

    private static final int DATA_SIZE = 1 << 13; // Arrays.MIN_ARRAY_SORT_GRAN (private field)

    @DataPoint
    public static String[] input = IntStream.rangeClosed(0, DATA_SIZE).mapToObj(i -> "test" + i).toArray(String[]::new);

    @Theory
    public void testDoSort_normalInput(String[] input) {
        ArraysSort arraysSort = new ArraysSort();
        List<Long> threadNames = arraysSort.doSort(input);
        assertThat(threadNames, everyItem(is(threadNames.get(0))));
    }

    @Theory
    public void testDoSortAsParallel_normalInput(String[] input) {
        ArraysSort arraysSort = new ArraysSort();
        List<Long> threadNames = arraysSort.doSortAsParallel(input);
        assertThat(threadNames, hasItems(not(threadNames.get(0))));
    }
}
