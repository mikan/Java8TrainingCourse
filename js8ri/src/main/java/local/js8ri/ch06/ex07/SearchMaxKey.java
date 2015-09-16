/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch06.ex07;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by mikan on 2015/09/16.
 *
 * @author mikan
 */
public class SearchMaxKey {

    @NonNull
    public static String findMaxKey(@NonNull ConcurrentHashMap<String, Long> source) {
        Objects.requireNonNull(source);
        return source.reduceEntries(1, (s1, s2) -> s1.getValue() > s2.getValue() ? s1 : s2).getKey();
    }

    private SearchMaxKey() {
        // static use only
    }
}
