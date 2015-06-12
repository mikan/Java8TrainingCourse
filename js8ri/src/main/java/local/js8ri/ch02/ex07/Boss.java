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

    public static void main(String[] args) {
        Stream<String> finite = Stream.of("yeah!", "yahoo!");
        System.out.println("finite result:\t\t\t" + isFinite(finite));
        Stream<String> infinite = Stream.generate(() -> "yeah!");
        System.out.println("infinite result:\t\t" + isFinite(infinite));
        Stream<String> infiniteParallel = Stream.generate(() -> "yeah!").parallel();
        System.out.println("infiniteParallel result:\t" + isFinite(infiniteParallel));
    }

    public static <T> boolean isFinite(Stream<T> stream) {
        return stream.spliterator().getExactSizeIfKnown() != -1;
    }

    public static <T> boolean isFiniteHungUp(Stream<T> stream) {
        return stream.count() >= 0; // DO NOT RUN!
    }
}
