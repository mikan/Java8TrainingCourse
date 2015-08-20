/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex18;

/**
 * An exception throwable function.
 *
 * @author mikan
 */
@FunctionalInterface
public interface ExceptionThrowableFunction<T, R> {

    /**
     * Applies this function to the given argument or throws exception.
     *
     * @param t the function argument
     * @return the function result
     * @throws Exception if the exception thrown
     */
    R apply(T t) throws Exception;
}
