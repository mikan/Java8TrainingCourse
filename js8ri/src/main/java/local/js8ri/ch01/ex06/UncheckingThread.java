/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch01.ex06;

/**
 *
 * @author mikan
 */
public class UncheckingThread {

    public static void main(String[] args) {
        new Thread(uncheck(() -> {
            System.out.println("Zzz");
            Thread.sleep(1000);
        })).start();
    }

    @FunctionalInterface
    public interface RunnableEx {
        public void run() throws Exception;
    }

    public static Runnable uncheck(RunnableEx runner) {
        return () -> {
            try {
                runner.run();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
