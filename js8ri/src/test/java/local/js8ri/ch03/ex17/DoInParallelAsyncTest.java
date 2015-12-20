/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch03.ex17;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.fail;

/**
 * @author mikan
 */
public class DoInParallelAsyncTest {

    private static final Runnable FIRST_NORMAL = () -> {
        System.out.println("[1st] begin at thread " + Thread.currentThread().getId());
        IntStream.range(0, Integer.MAX_VALUE).average();
        System.out.println("[1st] end");
    };

    private static final Runnable SECOND_NORMAL = () -> {
        System.out.println("[2nd] begin at thread " + Thread.currentThread().getId());
        IntStream.range(0, Integer.MAX_VALUE).average();
        System.out.println("[2nd] end");
    };
    private static final Runnable FIRST_RE = () -> {
        System.out.println("[1st] throw at thread " + Thread.currentThread().getId());
        throw new RuntimeException("RE thrown from 1st");
    };
    private static final Runnable SECOND_RE = () -> {
        System.out.println("[2nd] throw at thread " + Thread.currentThread().getId());
        throw new RuntimeException("RE thrown from 2nd");
    };

    @Test(timeout = 60000)
    public void testDoInAsync_normalInput() {
        DoInParallelAsync.doInParallelAsync(FIRST_NORMAL, SECOND_NORMAL, (t) -> fail());
    }

    @Test(timeout = 60000)
    public void testDoInAsync_firstFailedCase() {
        DoInParallelAsync.doInParallelAsync(FIRST_RE, SECOND_NORMAL, Assert::assertNotNull);
    }

    @Test(timeout = 60000)
    public void testDoInAsync_secondFailedCase() {
        DoInParallelAsync.doInParallelAsync(FIRST_NORMAL, SECOND_RE, Assert::assertNotNull);
    }
}
