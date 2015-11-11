/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch08.ex04;

import org.junit.Test;

import static local.js8ri.ch08.ex04.MinimumSeed.next;
import static local.js8ri.ch08.ex04.MinimumSeed.prev;
import static org.junit.Assert.assertEquals;

/**
 * @author mikan
 */
public class MinimumSeedTest {

    @Test
    public void testNext_zero() {
        assertEquals(11, next(0));
    }

    @Test
    public void testPrev_3times() {
        assertEquals(164311266871034L, prev(prev(prev(0))) ^ 25214903917L);
    }

    @Test
    public void testPrev_nextCheck() {
        assertEquals(0, prev(next(0)));
        assertEquals(10, prev(next(10)));
        assertEquals(100, prev(next(100)));
        long maxValue = (long) Math.pow(2, 48) - 1;
        assertEquals(maxValue, prev(next(maxValue)));
    }
}
