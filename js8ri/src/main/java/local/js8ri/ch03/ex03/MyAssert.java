/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch03.ex03;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

/**
 * {@code assert} is switchable the argument evaluation by "-ea" VM argument.
 * Lambda expression's lazy evaluation can provide same functionality.
 *
 * @author mikan
 * @see "JSR 41: A Simple Assertion Facility"
 */
public class MyAssert {

    private static boolean enabled = MyAssert.class.desiredAssertionStatus();

    static {
        System.out.println("MyAssert " + (enabled ? "enabled" : "disabled") + " by class.desiredAssertionStatus()");
    }

    public static void setEnabled(boolean enabled) {
        MyAssert.enabled = enabled;
    }

    public static void assertTrue(@Nullable BooleanSupplier condition) {
        if (enabled && (condition == null || !condition.getAsBoolean())) {
            throw new AssertionError("true expected, but condition is " + condition);
        }
    }

    public static void assertFalse(@Nullable BooleanSupplier condition) {
        if (enabled && (condition == null || condition.getAsBoolean())) {
            throw new AssertionError("false expected, but condition is " + condition);
        }
    }

    public static <T> void assertEquals(@Nullable Supplier<T> expected, @Nullable Supplier<T> actual) {
        if (enabled) {
            if (expected == null ? actual != null : actual == null || !equalsNonNullSuppliers(expected, actual)) {
                throw new AssertionError(expected + " expected, but actual is " + actual);
            }
        }
    }

    private static <T> boolean equalsNonNullSuppliers(@Nonnull Supplier<T> expected, @Nonnull Supplier<T> actual) {
        T expectedObject = expected.get(), actualObject = actual.get();
        return expectedObject == null ? actualObject == null : expectedObject.equals(actualObject);
    }
}
