/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex19;

import java.util.stream.Stream;

/**
 * @author mikan
 */
public class ReduceUser {

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("foo", "bar", "baz");
        // <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)
        String result1 = stringStream.reduce("", (s1, s2) -> s1 + s2, (s1, s2) -> s1 + s2);
        // NOTE: "String s1" is used for both parameter type ("super") and return type ("extends").
        System.out.println("result: " + result1);
    }
}
