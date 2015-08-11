/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch03.ex07;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author mikan
 */
public class ComparatorGenerator {

    private ComparatorGenerator() {
        // static use only
    }

    public static void main(String[] args) {
        String[] source = {"aaa", "aab", "aac", "aa a", "aa b", "aa c"};
        String[] ttt = source.clone();
        String[] fff = source.clone();
        Arrays.sort(ttt, generate(true, true, true));
        Arrays.sort(fff, generate(false, false, false));
        System.out.println("--- t t t ----");
        for (String s : ttt) {
            System.out.println(s);
        }
        System.out.println("--- f f f ----");
        for (String s : fff) {
            System.out.println(s);
        }
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
