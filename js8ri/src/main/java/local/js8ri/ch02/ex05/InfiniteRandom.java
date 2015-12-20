/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */
package local.js8ri.ch02.ex05;

import java.util.stream.Stream;

/**
 *
 * @author mikan
 */
public class InfiniteRandom {

    public static void main(String[] args) {
        Stream<Long> stream = Stream.iterate(1L, n -> random(25214903917L, 11, (long) Math.pow(2, 48), n));
        stream.limit(10).forEach(System.out::println);
    }

    private static long random(long a, long c, long m, long x) {
        return (a * x + c) % m;
    }
}
