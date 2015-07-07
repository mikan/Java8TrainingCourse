/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch01.ex09;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * @author mikan
 */
public interface Collection2<E> extends Collection<E> {

    default void forEachIf(Consumer<? super E> action, Predicate<? super E> filter) {
        Objects.requireNonNull(action);
        Objects.requireNonNull(filter);
        this.stream().filter(filter).forEach(action);
    }
}
