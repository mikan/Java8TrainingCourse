/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch02.ex07;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author mikan
 */
public class BossTest {

    @Rule
    public Timeout timeout = new Timeout(1, TimeUnit.SECONDS);

    @Test
    public void testIsFinite_allInput() {
        assertTrue(Boss.isFinite(Stream.of("foo", "bar")));
        assertTrue(Boss.isFinite(Stream.of("foo", "bar").parallel()));
        assertFalse(Boss.isFinite(Stream.generate(() -> "foo")));
        assertFalse(Boss.isFinite(Stream.generate(() -> "foo").parallel()));
    }

    @Test
    public void testIsFiniteHungUp_finiteInput() {
        assertTrue(Boss.isFiniteHungUp(Stream.of("foo", "bar").parallel()));
    }
}
