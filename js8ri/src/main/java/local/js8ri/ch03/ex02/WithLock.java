/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex02;

import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mikan
 */
public class WithLock {

    private WithLock() {
        // static use only
    }

    /**
     * Run {code runnable} with specified lock instance.
     *
     * @param lock     lock
     * @param runnable runnable
     * @throws NullPointerException if the argument(s) is(are) null.
     */
    public static void withLock(ReentrantLock lock, Runnable runnable) {
        Objects.requireNonNull(lock);
        Objects.requireNonNull(runnable);
        if (!lock.isLocked()) {
            lock.lock();
        }
        try {
            runnable.run();
        } finally {
            lock.unlock();
        }
    }
}
