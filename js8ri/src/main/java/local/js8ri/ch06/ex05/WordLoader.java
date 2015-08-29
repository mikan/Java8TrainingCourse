/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch06.ex05;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 *
 * @author mikan
 */
public class WordLoader {

    private static final int THREAD_POOL_SIZE = 100;

    public Map<String, Set<File>> loadWords(Set<File> files) {
        Objects.requireNonNull(files);
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        ConcurrentHashMap<String, Set<File>> result = new ConcurrentHashMap<>();
        files.forEach(f -> executorService.submit(() -> {
            String contents;
            try {
                contents = new String(Files.readAllBytes(f.toPath()), StandardCharsets.UTF_8);
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
                return;
            }
            Stream.of(contents.split("[\\P{L}]+")).forEach(s -> result.merge(
                    s.toLowerCase(), Collections.singleton(f), WordLoader::remap));
        }));
        executorService.shutdown();
        try {
            executorService.awaitTermination(3, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            System.err.println("Interrputed. " + ex.getMessage());
        }
        return result;
    }

    private static <T> Set<T> remap(Set<T> existingValue, Set<T> newValue) {
        Set<T> fileSet = new HashSet<>(existingValue.size() + newValue.size());
        fileSet.addAll(existingValue);
        fileSet.addAll(newValue);
        return fileSet;
    }
}
