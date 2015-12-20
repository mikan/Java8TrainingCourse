/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch06.ex04;

import java.util.Objects;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.LongStream;

/**
 *
 * @author mikan
 */
public class LongMinMax {

    public long max(LongStream longs) {
        Objects.requireNonNull(longs);
        LongAccumulator max = new LongAccumulator(Long::max, Long.MIN_VALUE);
        longs.parallel().forEach(max::accumulate);
        return max.get();
    }

    public long min(LongStream longs) {
        Objects.requireNonNull(longs);
        LongAccumulator max = new LongAccumulator(Long::min, Long.MAX_VALUE);
        longs.parallel().forEach(max::accumulate);
        return max.get();
    }
}
