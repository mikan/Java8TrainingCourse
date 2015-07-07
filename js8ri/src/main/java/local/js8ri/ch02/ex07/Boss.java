/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch02.ex07;

import java.util.Spliterator;
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

    /**
     * Dump characteristics.
     *
     * @param stream source stream
     * @param <T> type of stream
     * @see java.util.Spliterator
     */
    public static <T> void dumpCharacteristics(Stream<T> stream) {
        int characteristics = stream.spliterator().characteristics();
        System.out.println(stream.toString());
        System.out.println("ORDERED:    " + hasCharacteristics(characteristics, Spliterator.ORDERED));
        System.out.println("DISTINCT:   " + hasCharacteristics(characteristics, Spliterator.DISTINCT));
        System.out.println("SORTED:     " + hasCharacteristics(characteristics, Spliterator.SORTED));
        System.out.println("SIZED:      " + hasCharacteristics(characteristics, Spliterator.SIZED));
        System.out.println("NONNULL:    " + hasCharacteristics(characteristics, Spliterator.NONNULL));
        System.out.println("IMMUTABLE:  " + hasCharacteristics(characteristics, Spliterator.IMMUTABLE));
        System.out.println("CONCURRENT: " + hasCharacteristics(characteristics, Spliterator.CONCURRENT));
        System.out.println("SUBSIZED:   " + hasCharacteristics(characteristics, Spliterator.SUBSIZED));
    }

    private static boolean hasCharacteristics(int characteristics, int characteristic) {
        return (characteristics & characteristic) == characteristic;
    }
}
