/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex18;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author mikan
 */
public class UnCheckTest {

    @Test
    public void testUnChecked_normalCallableInput() {
        assertEquals("foo", Uncheck.unchecked(() -> "foo").get());
    }

    @Test(expected = RuntimeException.class)
    public void testUnChecked_throwingCallableInput() {
        Uncheck.unchecked(() -> {
            throw new Exception(); // throws Exception, but catch as RuntimeException.
        }).get();
    }

    @Test
    public void testUnChecked_normalExceptionThrowableFunctionInput() {
        assertEquals("bar", Uncheck.unchecked(s -> s.equals("foo") ? "bar" : s).apply("foo"));
    }

    @Test(expected = RuntimeException.class)
    public void testUnChecked_throwingExceptionThrowableFunctionInput() {
        Uncheck.unchecked(s -> {
            throw new Exception();
        }).apply("foo");
    }
}
