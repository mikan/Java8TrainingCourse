/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch06.ex08;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * Created by mikan on 2015/09/16.
 *
 * @author mikan
 */
public class ArraysSortTest {

    private static final ArraysSort SUT = new ArraysSort(); // system under test

    /**
     * <pre>
     *    SIZE    SEQUENTIAL  PARALLEL
     * ==========|==========|==========
     *      10000          2         12
     *     100000        179         96
     *    1000000        311        162
     *   10000000       3375        817
     * </pre>
     */
    @Test
    public void comparePerformance() {
        measureCollect(10000); // test run
        Map<Integer, Entry<Duration, Duration>> result = new TreeMap<>();
        System.out.println("   SIZE    SEQUENTIAL  PARALLEL");
        System.out.println("==========|==========|==========");
        for (int i = 1; i <= 4; i++) {
            int size = 1000 * (int) Math.pow(10, i);
            Entry<Duration, Duration> measure = measureCollect(size);
            System.out.printf("%10d %10d %10d%n", size, measure.getKey().toMillis(), measure.getValue().toMillis());
        }
    }

    private Entry<Duration, Duration> measureCollect(int size) {
        String[] data = createStringArray(size);
        return new SimpleImmutableEntry<>(
                measureRun(() -> SUT.doSort(data.clone())),
                measureRun(() -> SUT.doSortAsParallel(data.clone())));
    }

    private Duration measureRun(Runnable runnable) {
        Instant begin = Instant.now();
        runnable.run();
        Instant end = Instant.now();
        return Duration.between(begin, end);
    }

    private String[] createStringArray(int size) {
        Random random = new Random(LocalTime.now().hashCode());
        return IntStream.range(0, size).mapToObj(i -> String.valueOf(random.nextLong())).toArray(String[]::new);
    }
}
