/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch08.ex05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by mikan on 2015/10/03.
 *
 * @author mikan
 */
public class WordCounter {

    private static final int LENGTH_LIMIT = 12;

    public static void main(String[] args) throws IOException {
        String target = "js8ri/src/main/resources/war_and_peace.txt";
        if (args.length == 1) {
            target = args[0];
        }
        String contents = Files.readAllLines(Paths.get(target)).stream().collect(Collectors.joining());
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        int times = 100;
        System.out.println("stream:  " + time(WordCounter::countWithStream, words, times).getValue().toMillis() + " ms.");
        System.out.println("foreach: " + time(WordCounter::countWithForEach, words, times).getValue().toMillis() + " ms.");
        System.out.println("for:     " + time(WordCounter::countWithFor, words, times).getValue().toMillis() + " ms.");
    }

    public static long countWithStream(List<String> words) {
        return words.stream().filter(w -> w.length() > LENGTH_LIMIT).count();
    }

    public static long countWithForEach(List<String> words) {
        LongAdder count = new LongAdder();
        words.forEach(w -> { // using lambda exp.
            if (w.length() > LENGTH_LIMIT) {
                count.increment();
            }
        });
        return count.longValue();
    }

    public static long countWithFor(List<String> words) {
        long count = 0;
        for (String word : words) {
            if (word.length() > LENGTH_LIMIT) {
                count++;
            }
        }
        return count;
    }

    static <T extends List<String>, R> Map.Entry<R, Duration> time(Function<T, R> function, T input, int times) {
        R result = null;
        Instant begin = Instant.now();
        for (int i = 0; i < times; i++) {
            result = function.apply(input);
        }
        Instant end = Instant.now();
        return new SimpleImmutableEntry<>(result, Duration.between(begin, end));
    }

    private WordCounter() {
    }
}
