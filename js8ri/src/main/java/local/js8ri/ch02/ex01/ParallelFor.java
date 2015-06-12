/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch02.ex01;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author mikan
 */
public class ParallelFor {

    private static final int DEFAULT_WORD_LENGTH = 12;
    private static final int DEFAULT_SEGMENT_SIZE = 100;
    private final int wordLength;
    private final int segmentSize;

    public static void main(String[] args) throws IOException {
        ParallelFor.fetchAliceDotTxt();
        String contents = new String(Files.readAllBytes(Paths.get("out/alice.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        ParallelFor pf = new ParallelFor(DEFAULT_WORD_LENGTH, DEFAULT_SEGMENT_SIZE);
        System.out.println("Number of words: " + words.size());
        System.out.println("for:\t" + pf.countSequential(words));
        System.out.println("thread:\t" + pf.countParallel(words));
    }

    public static void fetchAliceDotTxt() {
        if (new File("out/alice.txt").exists()) {
            System.out.println("alice.txt already found. Download skipping.");
            return;
        }
        String target = "http://www.umich.edu/~umfandsf/other/ebooks/alice30.txt";
        try (InputStream input = new URL(target).openStream()) {
            Files.copy(input, Paths.get("out/alice.txt"), StandardCopyOption.REPLACE_EXISTING);
        } catch (MalformedURLException ex) {
            System.err.println("MalformedURLException" + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("IOException" + ex.getMessage());
        }
    }
    
    public ParallelFor(int wordLength, int segmentSize) {
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

   public int countParallel(List <String> words) {
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
            for (String w : segment) {
                if (w.length() > wordLength) {
                    count++;
                }
            }
            return count;
        }
    }
}
