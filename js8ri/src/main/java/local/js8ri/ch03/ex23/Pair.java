/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch03.ex23;

import java.util.AbstractMap;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author mikan
 */
public class Pair<T> extends AbstractMap.SimpleEntry<T, T> {

    public Pair(T key, T value) {
        super(key, value);
    }

    public <U> Pair<U> map(Function<? super T, ? extends U> mapper) {
        Objects.requireNonNull(mapper);
        return new Pair<>(mapper.apply(getKey()), mapper.apply(getValue()));
    }
}
