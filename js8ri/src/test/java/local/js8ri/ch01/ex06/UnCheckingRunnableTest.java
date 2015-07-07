/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch01.ex06;

import org.junit.Test;

/**
 * @author mikan
 */
public class UnCheckingRunnableTest {

    @Test(expected = RuntimeException.class)
    public void testUnCheck_RE() {
        UnCheckingRunnable.RunnableEx func = () -> {
            throw new Exception("dummy exception");
        };
        UnCheckingRunnable.unCheck(func).run(); // expect RE
    }

    @Test(expected = Error.class)
    public void testUnCheck_ER() {
        UnCheckingRunnable.RunnableEx func = () -> {
            throw new Error("dummy error");
        };
        UnCheckingRunnable.unCheck(func).run(); // expect Error
    }

    @Test
    public void testUnCheck_normalExit() {
        UnCheckingRunnable.RunnableEx func = () -> {
            // no-op
        };
        UnCheckingRunnable.unCheck(func).run(); // no exception
    }
}
