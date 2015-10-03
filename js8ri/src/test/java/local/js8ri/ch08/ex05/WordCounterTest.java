/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch08.ex05;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by mikan on 2015/10/03.
 *
 * @author mikan
 */
public class WordCounterTest {

    private static final String ALICE = "src/test/resources/alice.txt";
    private static final String WAR_AND_PEACE = "src/test/resources/war_and_peace.txt";
    private static final int LENGTH = 12;

    @Test
     public void testCountMethods_aliceResultCheck() throws IOException {
        List<String> words = Arrays.asList(Files.readAllLines(Paths.get(ALICE)).stream()
                .collect(Collectors.joining()).split("[\\P{L}]+"));
        long result1 = WordCounter.countWithFor(words);
        long result2 = WordCounter.countWithForEach(words);
        long result3 = WordCounter.countWithFor(words);
        assertEquals(result1, result2);
        assertEquals(result1, result3);
    }

    @Test
    public void testCountMethods_warAndPeaceResultCheck() throws IOException {
        List<String> words = Arrays.asList(Files.readAllLines(Paths.get(WAR_AND_PEACE)).stream()
                .collect(Collectors.joining()).split("[\\P{L}]+"));
        long result1 = WordCounter.countWithFor(words);
        long result2 = WordCounter.countWithForEach(words);
        long result3 = WordCounter.countWithFor(words);
        assertEquals(result1, result2);
        assertEquals(result1, result3);
    }

    @Test
    public void testTimes_normalInput() {
        Map.Entry<Long, Duration> result = WordCounter.time((w) -> (long) w.size(), Arrays.asList("1", "*2", "**3"), 1);
        assertEquals(3L, result.getKey(), 0);
        assertTrue(result.getValue().toMillis() >= 0);
    }
}
