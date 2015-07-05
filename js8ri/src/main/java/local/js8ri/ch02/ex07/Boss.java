/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch02.ex07;

import java.util.stream.Stream;

/**
 * @author mikan
 */
public class Boss {

    private Boss() {
        // static use only
    }

    public static <T> boolean isFinite(Stream<T> stream) {
        // Stream#spliterator() is a terminal operation... not useful.
        return stream.spliterator().getExactSizeIfKnown() != -1;
    }

    public static <T> boolean isFiniteHungUp(Stream<T> stream) {
        // DO NOT RUN!
        return stream.count() >= 0;
    }
}
