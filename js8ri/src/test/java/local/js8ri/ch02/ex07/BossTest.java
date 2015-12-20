/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
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
        // Finite streams
        assertTrue(Boss.isFinite(Stream.of("foo", "bar")));
        assertTrue(Boss.isFinite(Stream.of("foo", "bar").parallel()));
        // Infinite streams
        assertFalse(Boss.isFinite(Stream.generate(() -> "foo")));
        assertFalse(Boss.isFinite(Stream.generate(() -> "foo").parallel()));
        // Limited infinite streams
        assertFalse(Boss.isFinite(Stream.generate(() -> "foo").limit(100)));
        assertFalse(Boss.isFinite(Stream.generate(() -> "foo").limit(100).parallel()));
    }

    @Test
    public void testIsFiniteHungUp_finiteInput() {
        assertTrue(Boss.isFiniteHungUp(Stream.of("foo", "bar").parallel()));
    }

    @Test
    public void testDumpCharacteristics_run() {

        /*
        ORDERED:    false
        DISTINCT:   false
        SORTED:     false
        SIZED:      true
        NONNULL:    false
        IMMUTABLE:  false
        CONCURRENT: false
        SUBSIZED:   true
         */
        Boss.dumpCharacteristics(Stream.empty());

        /*
        ORDERED:    true
        DISTINCT:   false
        SORTED:     false
        SIZED:      true
        NONNULL:    false
        IMMUTABLE:  true
        CONCURRENT: false
        SUBSIZED:   true
         */
        Boss.dumpCharacteristics(Stream.of("foo", "bar"));

        /*
        ORDERED:    false
        DISTINCT:   false
        SORTED:     false
        SIZED:      false
        NONNULL:    false
        IMMUTABLE:  true
        CONCURRENT: false
        SUBSIZED:   false
         */
        Boss.dumpCharacteristics(Stream.generate(() -> "foo"));

        /*
        ORDERED:    false
        DISTINCT:   false
        SORTED:     false
        SIZED:      false
        NONNULL:    false
        IMMUTABLE:  false
        CONCURRENT: false
        SUBSIZED:   false
         */
        Boss.dumpCharacteristics(Stream.generate(() -> "foo").limit(10));
    }
}
