/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch02.ex11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * @author mikan
 */
public class ParallelCollect {

    private ParallelCollect() {
        // static use only
    }

    public static <T> ArrayList<T> collect(Stream<T> stream, int size) {
        Objects.requireNonNull(stream);
        if (!stream.isParallel()) {
            throw new IllegalArgumentException("not a parallel stream.");
        }
        if (size < 0) {
            throw new IllegalArgumentException("size is negative: " + size);
        }
        AtomicInteger index = new AtomicInteger();
        return stream.collect(Collector.of(
                // supplier
                () -> new ArrayList<>(Collections.nCopies(size, null)),
                // accumulator
                (list, t) -> list.set(index.getAndIncrement(), t),
                // combiner
                (list1, list2) -> {
                    ArrayList<T> list = new ArrayList<>();
                    list1.stream().filter(e -> e != null).forEach(list::add);
                    list2.stream().filter(e -> e != null).forEach(list::add);
                    return list;
                }
        ));
    }
}
