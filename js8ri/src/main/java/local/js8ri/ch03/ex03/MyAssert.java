/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex03;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

/**
 * @author mikan
 */
public class MyAssert {

    private static boolean enabled = MyAssert.class.desiredAssertionStatus();

    static {
        System.out.println("MyAssert " + (enabled ? "enabled" : "disabled") + " by class.desiredAssertionStatus()");
    }

    public static void setEnabled(boolean enabled) {
        MyAssert.enabled = enabled;
    }

    public static void assertTrue(BooleanSupplier condition) {
        if (enabled && (condition == null || !condition.getAsBoolean())) {
            throw new AssertionError("true expected, but condition is " + condition);
        }
    }

    public static void assertFalse(BooleanSupplier condition) {
        if (enabled && (condition == null || condition.getAsBoolean())) {
            throw new AssertionError("false expected, but condition is " + condition);
        }
    }

    public static <T> void assertEquals(Supplier<T> expected, Supplier<T> actual) {
        if (enabled) {
            if (expected == null ? actual != null : actual == null || !equalsNonNullSuppliers(expected, actual)) {
                throw new AssertionError(expected + " expected, but actual is " + actual);
            }
        }
    }

    private static <T> boolean equalsNonNullSuppliers(Supplier<T> expected, Supplier<T> actual) {
        T expectedObject = expected.get(), actualObject = actual.get();
        return expectedObject == null ? actualObject == null : expectedObject.equals(actualObject);
    }
}
