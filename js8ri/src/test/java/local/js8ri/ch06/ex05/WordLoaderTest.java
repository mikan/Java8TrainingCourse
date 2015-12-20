/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch06.ex05;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertFalse;

/**
 *
 * @author mikan
 */
public class WordLoaderTest {

    @Test(expected = NullPointerException.class)
    public void testLoadWords_NPE() {
        new WordLoader().loadWords(null);
    }

    @Test
    public void testLoadWords_largeInput() {
        Set<File> files = new HashSet<>();
        files.add(new File("src/test/resources/alice.txt"));
        files.add(new File("src/test/resources/war_and_peace.txt"));
        Instant begin = Instant.now();
        Map<String, Set<File>> result = new WordLoader().loadWords(files);
        Instant end = Instant.now();
        System.out.println("Number of words: " + result.size());
        System.out.println("Time: " + Duration.between(begin, end).toMillis() + " msec.");
        assertFalse(result.isEmpty());
        Assert.assertEquals(2, result.get("a").size());
    }

    @Test
    public void testLoadWords_readmeInput() {
        Set<File> files = new HashSet<>();
        files.add(new File("../README.md"));
        Instant begin = Instant.now();
        Map<String, Set<File>> result = new WordLoader().loadWords(files);
        Instant end = Instant.now();
        System.out.println("Number of words: " + result.size());
        System.out.println("Time: " + Duration.between(begin, end).toMillis() + " msec.");
        assertFalse(result.isEmpty());
    }
}
