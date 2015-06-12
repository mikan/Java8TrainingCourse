/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch02.ex04;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author mikan
 */
public class WhatStreamOf {

    public static void main(String[] args) {
        int[] values = {1, 4, 9, 16};
        Stream<int[]> stream = Stream.of(values);
        System.out.println(stream); // java.util.stream.ReferencePipeline$Head@6d06d69c
        stream.peek(System.out::println) // [I@36baf30c
                .forEach(action -> {
                    for (int i = 0; i < action.length; i++) {
                        System.out.println(action[i]);
                    }
                });
        IntStream intStream = IntStream.of(values);
        System.out.println(intStream); // java.util.stream.IntPipeline$Head@7852e922
        intStream.forEach(System.out::println); // 1 4 9 16
    }
}
