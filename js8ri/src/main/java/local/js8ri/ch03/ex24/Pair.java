/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex24;

import javax.annotation.Nullable;
import java.util.AbstractMap;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author mikan
 */
public class Pair<T> extends AbstractMap.SimpleEntry<T, T> {

    public Pair(@Nullable T key, @Nullable T value) {
        super(key, value);
    }

    /**
     * Applies key or value.
     *
     * @param mapper mapper
     * @param <U>    type of result
     * @return result
     */
    public <U> Pair<U> flatMap(Function<? super T, Pair<U>> mapper) {
        Objects.requireNonNull(mapper);
        T target = getKey() != null ? getKey() : getValue();
        return target == null ? null : mapper.apply(target);
        // Defining (k1, v1, k2 ,v2) to (k3, v3) operation is very difficult.
    }
}
