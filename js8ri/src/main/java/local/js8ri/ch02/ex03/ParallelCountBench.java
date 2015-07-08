/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch02.ex03;


import local.js8ri.ch02.ex01.ParallelFor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author mikan
 */
public class ParallelCountBench {

    private ParallelCountBench() {
        //static use only
    }

    public static void run(String path, int length) throws IOException {
        run(Paths.get(path), length);
    }

    public static void run(Path path, int length) throws IOException {
        Objects.requireNonNull(path);
        if (length < 0) {
            throw new IllegalArgumentException("length is negative: " + length);
        }
        String contents = Files.readAllLines(path).stream().collect(Collectors.joining());
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        ParallelFor pf10 = new ParallelFor(length, 10);
        ParallelFor pf100 = new ParallelFor(length, 100);
        ParallelFor pf1000 = new ParallelFor(length, 1000);

        // Test run
        countSequential(words, length);
        countParallel(words, length);
        pf10.countSequential(words);
        pf100.countSequential(words);
        pf1000.countSequential(words);

        // Metrics run
        long beginParallel = System.nanoTime();
        long countParallel = countParallel(words, length);
        long endParallel = System.nanoTime();
        long beginSequential = System.nanoTime();
        long countSequential = countSequential(words, length);
        long endSequential = System.nanoTime();
        long beginPf10 = System.nanoTime();
        long countPf10 = pf10.countSequential(words);
        long endPf10 = System.nanoTime();
        long beginPf100 = System.nanoTime();
        long countPf100 = pf100.countSequential(words);
        long endPf100 = System.nanoTime();
        long beginPf1000 = System.nanoTime();
        long countPf1000 = pf100.countSequential(words);
        long endPf1000 = System.nanoTime();
        System.out.println("Parallel Stream:   " + n2m(endParallel - beginParallel) + " [" + countParallel + "]");
        System.out.println("Sequential Stream: " + n2m(endSequential - beginSequential) + " [" + countSequential + "]");
        System.out.println("ParallelFor(10):   " + n2m(endPf10 - beginPf10) + " [" + countPf10 + "]");
        System.out.println("ParallelFor(100):  " + n2m(endPf100 - beginPf100) + " [" + countPf100 + "]");
        System.out.println("ParallelFor(1000): " + n2m(endPf1000 - beginPf1000) + " [" + countPf1000 + "]");

        // Take 1
        // Parallel Stream:   7.709979 [1946] 1 (Fastest!)
        // Sequential Stream: 9.436506 [1946] 4
        // ParallelFor(10):   8.829252 [1946] 2
        // ParallelFor(100):  9.951939 [1946] 5
        // ParallelFor(1000): 8.958964 [1946] 3
        // Take 2
        // Parallel Stream:   7.560811 [1946] 3
        // Sequential Stream: 8.013435 [1946] 5
        // ParallelFor(10):   6.383167 [1946] 1 (Fastest!)
        // ParallelFor(100):  7.858805 [1946] 4
        // ParallelFor(1000): 7.229023 [1946] 2
        // Take 3
        // Parallel Stream:   7.701787 [1946] 3
        // Sequential Stream: 7.921954 [1946] 5
        // ParallelFor(10):	  6.7822   [1946] 1 (Fastest!)
        // ParallelFor(100):  7.150513 [1946] 2
        // ParallelFor(1000): 7.980666 [1946] 5
    }

    private static long countParallel(List<String> words, int length) {
        return words.parallelStream().filter(w -> w.length() > length).count();
    }

    private static long countSequential(List<String> words, int length) {
        return words.stream().filter(w -> w.length() > length).count();
    }

    private static double n2m(long nano) {
        return nano / 1000000.0;
    }
}
