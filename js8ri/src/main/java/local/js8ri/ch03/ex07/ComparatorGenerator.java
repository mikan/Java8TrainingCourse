/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch03.ex07;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author mikan
 */
public class ComparatorGenerator {

    public static void main(String[] args) {
        String[] source = {"111", "112", "113", "11 1", "11 2", "11 3"};
        String[] ttt = source.clone();
        String[] fff = source.clone();
        Arrays.sort(ttt, generate(true, true, true));
        Arrays.sort(ttt, generate(false, false, false));
        System.out.println("--- t t t ----");
        for (String s : ttt) {
            System.out.println(s);
        }
        System.out.println("--- f f f ----");
        for (String s : fff) {
            System.out.println(s);
        }
    }

    public static Comparator<String> generate(
            boolean naturalOrder, boolean caseSensitive, boolean acceptSpace) {
        return (String o1, String o2) -> {
            String s1 = acceptSpace ? o1 : o1.replaceAll(" ", "");
            String s2 = acceptSpace ? o2 : o2.replaceAll(" ", "");
            int result = caseSensitive ? s1.compareTo(s2) : s1.compareToIgnoreCase(s2);
            return naturalOrder ? result : -result;
        };
    }
}
