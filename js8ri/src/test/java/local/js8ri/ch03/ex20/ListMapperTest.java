/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex20;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author mikan
 */
public class ListMapperTest {

    @Test
    public void testMap_normalInput() {
        List<String> source = Arrays.asList("one", "two", "tree");
        List<Integer> mapped = ListMapper.map(source, String::length);
        assertThat(mapped, is(Arrays.asList(3, 3, 4)));
    }

    @Test(expected = NullPointerException.class)
    public void testMap_1stNPE() {
        ListMapper.map(null, String::length);
    }

    @Test(expected = NullPointerException.class)
    public void testMap_2ndNPE() {
        ListMapper.map(Collections.emptyList(), null);
    }
}
