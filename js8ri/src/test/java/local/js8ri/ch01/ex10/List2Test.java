/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch01.ex10;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * @author mikan
 */
public class List2Test {

    @Test(expected = IllegalArgumentException.class)
    public void testNCopies_IAE() {
        List2.nCopies(-1, null);
    }

    @Test
    public void testNCopies_normalInput() {
        int size = 100;
        String content = "foo";
        List2<String> result = List2.nCopies(size, content);
        assertEquals(size, result.size());
        assertThat(result, everyItem(is(content)));
    }

    @Test
    public void testFill_normalInput() {
        int size = 100;
        String prefix = "foo";
        String fill = "bar";
        List2<String> input = new ArrayList2<>();
        IntStream.range(0, 100).mapToObj(i -> prefix + i).forEach(input::add);
        input.fill(fill);
        assertEquals(size, input.size());
        assertThat(input, everyItem(is(fill)));
    }
}
