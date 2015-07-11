/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex02;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

import static org.junit.Assert.assertTrue;

/**
 * @author mikan
 */
public class WithLockTest {

    @Test(expected = NullPointerException.class)
    public void testWithLock_lockNPE() {
        WithLock.withLock(null, () -> System.out.println("test"));
    }

    @Test(expected = NullPointerException.class)
    public void testWithLock_runNPE() {
        WithLock.withLock(new ReentrantLock(), null);
    }

    @Test
    public void testWithLock_unlockedCase() {
        AtomicBoolean called = new AtomicBoolean();
        ReentrantLock lock = new ReentrantLock();
        WithLock.withLock(lock, () -> called.set(true));
        assertTrue(called.get());
    }

    @Test
    public void testWithLock_lockedCase() {
        AtomicBoolean called = new AtomicBoolean();
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        WithLock.withLock(lock, () -> called.set(true));
        assertTrue(called.get());
    }
}
