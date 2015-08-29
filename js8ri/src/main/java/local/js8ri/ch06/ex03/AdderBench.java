/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch06.ex03;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

/**
 *
 * @author mikan
 */
public class AdderBench {

    public static void main(String[] args) {
        AdderBench bench = new AdderBench();
        bench.incrementWithAtomicLong(1000, 100000);
        bench.incrementWithLongAdder(1000, 100000);
    }

    public void incrementWithAtomicLong(int threads, int limit) {
        AtomicLong adder = new AtomicLong();
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        Instant begin = Instant.now();
        IntStream.range(0, threads).forEach(i -> executorService.submit(() -> IntStream.range(0, limit).forEach(n -> adder.incrementAndGet())));
        executorService.shutdown();
        Instant end = Instant.now();
        System.out.println("AtomicLong: " + Duration.between(begin, end).toMillis() + "msec. Value: " + adder.longValue());
    }

    public void incrementWithLongAdder(int threads, int limit) {
        LongAdder adder = new LongAdder();
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        Instant begin = Instant.now();
        IntStream.range(0, threads).forEach(i -> executorService.submit(() -> IntStream.range(0, limit).forEach(n -> adder.increment())));
        executorService.shutdown();
        Instant end = Instant.now();
        System.out.println("LongAdder:  " + Duration.between(begin, end).toMillis() + "msec. Value: " + adder.longValue());
    }

}
