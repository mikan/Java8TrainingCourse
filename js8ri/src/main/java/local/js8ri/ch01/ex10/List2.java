/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch01.ex10;

import java.util.List;
import java.util.stream.IntStream;

/**
 * @param <E> the type of elements in this list
 * @author ykatoh
 */
public interface List2<E> extends List<E> {

    // static way: utility method
    static <E> List2<E> nCopies(int n, E o) {
        if (n < 0) {
            throw new IllegalArgumentException("List length = " + n);
        }
        List2<E> list = new ArrayList2<>();
        for (int i = 0; i < n; i++) {
            list.add(o);
        }
        return list; // modifiable...
    }

    // default way: instance-depend method
    default void fill(E obj) {
        IntStream.range(0, size()).forEach(i -> set(i, obj));
    }
}
