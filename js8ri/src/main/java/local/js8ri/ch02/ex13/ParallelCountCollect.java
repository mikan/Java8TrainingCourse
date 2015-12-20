/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch02.ex13;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author mikan
 */
public class ParallelCountCollect {

    private ParallelCountCollect() {
        // static use only
    }

    public static int[] countShortWords(Stream<String> words, int threshold) {
        Objects.requireNonNull(words);
        if (threshold < 0) {
            throw new IllegalArgumentException("threshold is negative: " + threshold);
        }
        Map<Integer, Long> counts = words.parallel().filter(w -> w.length() < threshold)
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        return IntStream.range(0, threshold).map(i -> counts.get(i) == null ? 0 : counts.get(i).intValue()).toArray();
    }
}
