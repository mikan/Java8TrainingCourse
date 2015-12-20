/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */
package local.js8ri.ch01.ex07;

/**
 * @author mikan
 */
public class AndThen {

    public static Runnable andThen(Runnable first, Runnable second) {
        return () -> {
            first.run();
            second.run();
        };
    }

    public static Runnable andThenWithThread(Runnable run1, Runnable run2) {
        return () -> {
            Thread first = new Thread(run1);
            first.start();
            try {
                first.join();
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
            Thread second = new Thread(run2);
            second.start();
        };
    }
}
