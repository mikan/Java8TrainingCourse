/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch06.ex09;

import org.junit.Test;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author mikan
 */
public class ParallelFibonacciTest {

    private static final long[] FIBONACCI_LONG = {1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144};

    private static final BigInteger[] FIBONACCI_BI = LongStream.of(FIBONACCI_LONG)
            .mapToObj(BigInteger::valueOf).toArray(BigInteger[]::new);

    @Test
    public void testFibonacciAsLong_normalInput() {
        assertThat(IntStream.rangeClosed(1, FIBONACCI_LONG.length).mapToLong(
                ParallelFibonacci::fibonacciAsLong).toArray(), is(FIBONACCI_LONG));
    }

    @Test
    public void testFibonacciAsBigInteger_normalInput() {
        assertThat(IntStream.rangeClosed(1, FIBONACCI_BI.length).mapToObj(
                ParallelFibonacci::fibonacciAsBigInteger).toArray(), is(FIBONACCI_BI));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFibonacciAsLong_IAE() {
        ParallelFibonacci.fibonacciAsLong(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFibonacciAsBigInteger_IAE() {
        ParallelFibonacci.fibonacciAsBigInteger(0);
    }
}
