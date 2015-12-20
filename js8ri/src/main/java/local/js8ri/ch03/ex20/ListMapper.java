/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch03.ex20;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author mikan
 */
public class ListMapper {

    private ListMapper() {
        // static use only
    }

    public static <T, U> List<U> map(List<T> list, Function<T, U> mapper) {
        Objects.requireNonNull(list);
        Objects.requireNonNull(mapper);
        return list.stream().map(mapper::apply).collect(Collectors.toList());
    }
}
