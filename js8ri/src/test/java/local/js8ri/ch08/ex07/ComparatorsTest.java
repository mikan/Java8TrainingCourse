/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch08.ex07;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by mikan on 2015/11/13.
 *
 * @author mikan
 */
public class ComparatorsTest {

    @Test
    public void testCompare_equals() {
        List<String> strings1 = Arrays.asList(null, "A", "B", "C", null);
        List<String> strings2 = new ArrayList<>(strings1);
        Collections.sort(strings1, Comparators.reversedNullsFirst());
        Collections.sort(strings2, Comparator.<String>naturalOrder().reversed());
        assertThat(strings1, is(strings2));
    }
}
