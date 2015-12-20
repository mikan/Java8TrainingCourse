/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch03.ex16;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author mikan
 */
public class DoInOrderAsyncTest {

    @Test
    public void testDoInOrderAsync_normal2Input() {
        DoInOrderAsync.doInOrderAsync(() -> "foo", (s, t) -> assertEquals("foo", s));
    }

    @Test
    public void testDoInOrderAsync_normal3Input() {
        DoInOrderAsync.doInOrderAsync(() -> "foo", (s, t) -> assertEquals("foo", s), (t) -> fail());
    }
}
