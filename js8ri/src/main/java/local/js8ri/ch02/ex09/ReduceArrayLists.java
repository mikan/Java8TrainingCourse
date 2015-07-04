/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch02.ex09;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author ykatoh
 */
public class ReduceArrayLists<T> {

    private final Stream<ArrayList<T>> source;

    public ReduceArrayLists(Stream<ArrayList<T>> source) {
        Objects.requireNonNull(source);
        this.source = source;
    }

    public ArrayList<T> toArrayList1() {
        return source.reduce((x, y) -> {
            ArrayList<T> result = new ArrayList<>(x.size() + y.size());
            result.addAll(x);
            result.addAll(y);
            return result;
        }).orElse(new ArrayList<>());
    }

    public ArrayList<T> toArrayList2() {
        return source.reduce(new ArrayList<>(), (x, y) -> {
            ArrayList<T> result = new ArrayList<>(x.size() + y.size());
            result.addAll(x);
            result.addAll(y);
            return result;
        });
    }

    public ArrayList<T> toArrayList3() {
        return source.reduce(new ArrayList<>(),
                (x, y) -> {
                    x.addAll(y);
                    return x;
                },
                (x, y) -> {
                    ArrayList<T> result = new ArrayList<>(x.size() + y.size());
                    result.addAll(x);
                    result.addAll(y);
                    return result;
                });
    }
}
