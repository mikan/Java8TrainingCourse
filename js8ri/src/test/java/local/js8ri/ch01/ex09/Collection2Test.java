/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch01.ex09;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;

/**
 * @author mikan
 */
public class Collection2Test {

    @Test
    public void testForEachIf_NormalCall() {
        String prefix = "test-";
        List2<String> list = new ArrayList2<>();
        IntStream.range(0, 10).mapToObj(i -> prefix + i).forEach(list::add);
        list.add("foo");
        list.add("bar");
        list.forEachIf(i -> assertTrue(i.startsWith(prefix)), s -> s.contains("-"));
    }
}
