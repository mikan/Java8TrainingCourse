/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch08.ex01;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by mikan on 2015/09/16.
 *
 * @author mikan
 */
public class UnsignedIntTest {

    private int max = Integer.MAX_VALUE;

    @Test
    public void testAdd_normalInput() {
        assertEquals(0, new UnsignedInt(0).add(0));
        assertEquals(max, new UnsignedInt(max).add(0));
        assertEquals(max, new UnsignedInt(0).add(max));
    }

    @Test
    public void testAdd_overflowInput() {
        assertNotEquals(max + 1, new UnsignedInt(Integer.MAX_VALUE).add(1));
    }
}
