/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch02.ex03;


import local.js8ri.ch02.ex01.ParallelFor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author mikan
 */
public class ParallelCountBench {

    public static void main(String[] args) throws IOException {
        fetchWarAndPeace();
        String contents = new String(Files.readAllBytes(Paths.get("out/war_and_peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        ParallelFor pf10 = new ParallelFor(12, 10);
        ParallelFor pf100 = new ParallelFor(12, 100);
        ParallelFor pf1000 = new ParallelFor(12, 1000);
        
        // Test run
        countSequential(words);
        countParallel(words);
        pf10.countSequential(words);
        pf100.countSequential(words);
        pf1000.countSequential(words);

        // Metrics run
        long beginParallel = System.nanoTime();
        long countPararell = countParallel(words);
        long endParallel = System.nanoTime();
        long beginSequential = System.nanoTime();
        long countSequential = countSequential(words);
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
        System.out.println("Parallel:\t\t" + n2m(endParallel - beginParallel) + " [" + countPararell + "]");
        System.out.println("Sequential:\t\t" + n2m(endSequential - beginSequential) + " [" + countSequential + "]");
        System.out.println("ParallelFor(10):\t" + n2m(endPf10 - beginPf10) + " [" + countPf10 + "]");
        System.out.println("ParallelFor(100):\t" + n2m(endPf100 - beginPf100) + " [" + countPf100 + "]");
        System.out.println("ParallelFor(1000):\t" + n2m(endPf1000 - beginPf1000) + " [" + countPf1000 + "]");

        // Take 1
        // Parallel:		7.709979 [1946] 1 (Fastest!)
        // Sequential:		9.436506 [1946] 4
        // ParallelFor(10):	8.829252 [1946] 2
        // ParallelFor(100):	9.951939 [1946] 5
        // ParallelFor(1000):	8.958964 [1946] 3
        // Take 2
        // Parallel:		7.560811 [1946] 3
        // Sequential:		8.013435 [1946] 5
        // ParallelFor(10):	6.383167 [1946] 1 (Fastest!)
        // ParallelFor(100):	7.858805 [1946] 4
        // ParallelFor(1000):	7.229023 [1946] 2
        // Take 3
        // Parallel:		7.701787 [1946] 3
        // Sequential:		7.921954 [1946] 5
        // ParallelFor(10):	6.7822 [1946]   1 (Fastest!)
        // ParallelFor(100):	7.150513 [1946] 2
        // ParallelFor(1000):	7.980666 [1946] 5
    }

    private static long countParallel(List<String> words) {
        return words.parallelStream().filter(w -> w.length() > 12).count();
    }

    private static long countSequential(List<String> words) {
        return words.stream().filter(w -> w.length() > 12).count();
    }

    public static void fetchWarAndPeace() {
        if (new File("out/war_and_peace.txt").exists()) {
            System.out.println("war_and_peace.txt already found. Download skipping.");
            return;
        }
        String target = "http://www.gutenberg.org/files/2600/2600.txt";
        try (InputStream input = new URL(target).openStream()) {
            Files.copy(input, Paths.get("out/war_and_peace.txt"), StandardCopyOption.REPLACE_EXISTING);
        } catch (MalformedURLException ex) {
            System.err.println("MalformedURLException" + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("IOException" + ex.getMessage());
        }
    }

    private static double n2m(long nano) {
        return nano / 1000000.0;
    }
}
