/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex18;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author mikan
 */
public class Uncheck {

    private Uncheck() {
        // static use only
    }

    /* Original code (Chapter 3 Section 3.8) */
    public static <T> Supplier<T> unchecked(Callable<T> f) {
        Objects.requireNonNull(f);
        return () -> {
            try {
                return f.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            } catch (Throwable t) {
                throw t;
            }
        };
    }

    public static <T, U> Function<T, U> unchecked(ExceptionThrowableFunction<T, U> f) {
        Objects.requireNonNull(f);
        return u -> {
            try {
                return f.apply(u);
            } catch (Exception e) {
                throw new RuntimeException(e);
            } catch (Throwable t) {
                throw t;
            }
        };
    }
}
