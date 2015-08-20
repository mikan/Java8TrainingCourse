/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex22;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * @author mikan
 */
public class FlatMapUser {

    private FlatMapUser() {
        // static use only
    }

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("foo");
        Optional<Integer> result = optional.flatMap(s -> Optional.of(s.length()));
        System.out.println("expected=3, result=" + result.get());
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        // nothing flatMap in CompletableFuture
        System.out.println(completableFuture.toString());
    }
}
