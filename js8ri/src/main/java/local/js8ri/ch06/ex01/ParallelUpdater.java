/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch06.ex01;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

/**
 * Created by mikan on 2015/09/16.
 *
 * @author mikan
 */
public class ParallelUpdater {

    private static final int THREAD_POOL_SIZE = 10;

    public static String calculateLongestWord(Set<File> files) {
        Objects.requireNonNull(files);
        AtomicReference<String> longest = new AtomicReference<>("");
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
            Stream.of(contents.split("[\\P{L}]+")).forEach(w -> longest.accumulateAndGet(w, (w1, w2) ->
                    w1.length() > w2.length() ? w1 : w2));
        }));
        executorService.shutdown();
        try {
            executorService.awaitTermination(3, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            System.err.println("Interrputed. " + ex.getMessage());
        }
        return longest.get();
    }

    private ParallelUpdater() {
        // static use only
    }
}
