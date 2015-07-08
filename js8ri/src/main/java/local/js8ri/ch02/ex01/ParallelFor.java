/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch02.ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author mikan
 */
public class ParallelFor {

    private final int wordLength;
    private final int segmentSize;

    public ParallelFor(int wordLength, int segmentSize) {
        if (wordLength < 1) {
            throw new IllegalArgumentException("illegal word length: " + wordLength);
        }
        if (segmentSize < 1) {
            throw new IllegalArgumentException("illegal segment size: " + segmentSize);
        }
        this.wordLength = wordLength;
        this.segmentSize = segmentSize;
    }

    public int countSequential(List<String> words) {
        int count = 0;
        for (String w : words) {
            if (w.length() > wordLength) {
                count++;
            }
        }
        return count;
    }

    public int countParallel(List<String> words) {
        int count = 0;
        ExecutorService exec = Executors.newSingleThreadExecutor();
        List<Future<Integer>> futures = new ArrayList<>();
        int begin = 0;
        int end = segmentSize;
        while (true) {
            Future<Integer> future;
            if (end >= words.size()) {
                end = words.size();
                future = exec.submit(new Counter(words.subList(begin, end), wordLength));
                // System.out.println("[2] " + begin + " " + end);
                futures.add(future);
                break;
            } else {
                future = exec.submit(new Counter(words.subList(begin, end), wordLength));
                // System.out.println("[1] " + begin + " " + end);
                futures.add(future);
                begin = end;
                end = begin + segmentSize;
            }
        }
        for (Future<Integer> future : futures) {
            try {
                int tmpCount = future.get();
                count += tmpCount;
            } catch (InterruptedException | ExecutionException e) {
                System.err.println(e);
            }
        }
        exec.shutdown();
        return count;
    }

    private static class Counter implements Callable<Integer> {

        private final List<String> segment;
        private final int wordLength;
        private int count = 0;

        public Counter(List<String> segment, int wordLength) {
            this.segment = segment;
            this.wordLength = wordLength;
        }

        @Override
        public Integer call() throws Exception {
            segment.stream().filter(w -> w.length() > wordLength).forEach(w -> count++);
            return count;
        }
    }
}
