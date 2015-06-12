/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch02.ex02;

import local.js8ri.ch02.ex01.ParallelFor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author mikan
 */
public class FilterBehavior {

    private static int cursor = 0;

    public static void main(String[] args) throws IOException {
        ParallelFor.fetchAliceDotTxt();
        String contents = new String(Files.readAllBytes(Paths.get("out/alice.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        System.out.println("Number of words: " + words.size());
        long count = words.stream().filter(w -> {
            boolean result = w.length() > 12;
            print(result);
            return result;
        }).limit(5).count();
        System.out.println();
        System.out.println("count: " + count);
    }

    private static void print(boolean result) {
        System.out.print(result ? "#" : ".");
        cursor++;
        if (cursor >= 80) {
            System.out.println();
            cursor = 0;
        }
    }
}
