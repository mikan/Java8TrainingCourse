/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */
package local.js8ri.ch01.ex06;

/**
 * @author mikan
 */
public class UnCheckingRunnable {

    @FunctionalInterface
    public interface RunnableEx {
        void run() throws Exception;
    }

    public static Runnable unCheck(RunnableEx runner) {
        return () -> {
            try {
                runner.run();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
