/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch01.ex01;

import java.util.Arrays;

/**
 * @author mikan
 */
public class ArraysSort {

    public static void main(String[] args) {

        String[] words = {"hoge", "fuga", "piyo", "foo", "bar"};

        System.out.println("[main]   thread: " + Thread.currentThread().getName()); // Result: main

        Arrays.sort(words, (first, second) -> {
            System.out.println("[lambda] thread: " + Thread.currentThread().getName()); // Result: main
            return Integer.compare(first.length(), second.length());
        });
    }
}
