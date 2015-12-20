/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */
package local.js8ri.ch03.ex07;

import java.util.Comparator;

/**
 * @author mikan
 */
public class ComparatorGenerator {

    private ComparatorGenerator() {
        // static use only
    }

    public static Comparator<String> generate(boolean naturalOrder, boolean caseSensitive, boolean acceptSpace) {
        return (o1, o2) -> {
            String s1 = acceptSpace ? o1 : o1.replaceAll(" ", "");
            String s2 = acceptSpace ? o2 : o2.replaceAll(" ", "");
            int result = caseSensitive ? s1.compareTo(s2) : s1.compareToIgnoreCase(s2);
            return naturalOrder ? result : -result;
        };
    }
}
