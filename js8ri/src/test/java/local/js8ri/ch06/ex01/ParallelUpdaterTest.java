/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch06.ex01;

import org.junit.Test;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;

/**
 * Created by mikan on 2015/09/16.
 *
 * @author mikan
 */
public class ParallelUpdaterTest {

    @Test
    public void testCalculateLongestWord_largeInput() {
        Set<File> files = new HashSet<>();
        files.add(new File("src/test/resources/alice.txt"));
        files.add(new File("src/test/resources/war_and_peace.txt"));
        doCalculation(files);
    }

    @Test
    public void testLoadWords_readmeInput() {
        Set<File> files = new HashSet<>();
        files.add(new File("../README.md"));
        doCalculation(files);
    }

    private void doCalculation(Set<File> files) {
        Instant begin = Instant.now();
        String result = ParallelUpdater.calculateLongestWord(files);
        Instant end = Instant.now();
        System.out.println("Longest word: " + result + " (length: " + result.length() + ")");
        System.out.println("Time: " + Duration.between(begin, end).toMillis() + " msec.");
        assertFalse(result.isEmpty());
    }
}
