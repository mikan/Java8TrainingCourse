/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch02.ex12;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * @author mikan
 */
public class ParallelCount {

    private ParallelCount() {
        // static use only
    }

    public static int[] countShortWords(Stream<String> words, int threshold) {
        Objects.requireNonNull(words);
        if (threshold < 0) {
            throw new IllegalArgumentException("threshold is negative: " + threshold);
        }
        AtomicInteger[] shortWords = new AtomicInteger[threshold];
        // Arrays.fill(shortWords, new AtomicInteger()); // Unusable because every items are same instance!
        for (int i = 0; i < threshold; i++) {
            shortWords[i] = new AtomicInteger();
        }
        words.parallel().filter(w -> w.length() < threshold).forEach(w -> shortWords[w.length()].getAndIncrement());
        return Arrays.asList(shortWords).stream().mapToInt(i -> i.get()).toArray();
    }
}
