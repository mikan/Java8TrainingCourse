/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch02.ex02;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @author mikan
 */
public class FilterBehaviorTest {

    private static final String INPUT_FILE = "src/test/resources/alice.txt";

    @Test
    public void testPrint_normalInput() throws IOException {
        FilterBehavior filter = new FilterBehavior();
        String contents = new String(Files.readAllBytes(Paths.get(INPUT_FILE)), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        System.out.println("Number of words: " + words.size());
        long count = words.stream().filter(w -> {
            boolean result = w.length() > 12;
            filter.print(result);
            return result;
        }).limit(5).count();
        System.out.println();
        System.out.println("count: " + count);
    }
}
