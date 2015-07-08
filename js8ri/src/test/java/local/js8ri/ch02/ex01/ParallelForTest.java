/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch02.ex01;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * @author mikan
 */
public class ParallelForTest {

    private static final String INPUT_FILE = "src/main/resources/alice.txt";
    private static final int DEFAULT_WORD_LENGTH = 12;
    private static final int DEFAULT_SEGMENT_SIZE = 100;

    private static List<String> words;

    @BeforeClass
    public static void loadWords() throws IOException {
        String content = Files.readAllLines(Paths.get(INPUT_FILE)).stream().collect(Collectors.joining());
        words = Arrays.asList(content.split("[\\P{L}]+"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParallelFor_wordLengthIAE() {
        new ParallelFor(0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParallelFor_segmentSizeIAE() {
        new ParallelFor(1, 0);
    }

    @Test
    public void testCounts_normalRun() {
        ParallelFor pf = new ParallelFor(DEFAULT_WORD_LENGTH, DEFAULT_SEGMENT_SIZE);
        System.out.println("words:  " + words.size());
        System.out.println("for:    " + pf.countSequential(words));
        System.out.println("thread: " + pf.countParallel(words));
    }

    @Test
    public void testCounts_equalityCheck() {
        ParallelFor pf1 = new ParallelFor(1, 1);
        assertEquals(pf1.countSequential(words), pf1.countParallel(words));
        ParallelFor pf2 = new ParallelFor(DEFAULT_WORD_LENGTH, 1);
        assertEquals(pf2.countSequential(words), pf2.countParallel(words));
        ParallelFor pf3 = new ParallelFor(1, DEFAULT_SEGMENT_SIZE);
        assertEquals(pf3.countSequential(words), pf3.countParallel(words));
    }
}
