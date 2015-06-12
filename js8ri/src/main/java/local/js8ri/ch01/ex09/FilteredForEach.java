/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch01.ex09;

/**
 *
 * @author mikan
 */
public class FilteredForEach {

    public static void main(String[] args) {

        List2<String> list = new ArrayList2<>();
        list.add("mikan");
        list.add("MrBearing");
        list.add("YuichiroSato");
        list.add("namichan0801");
        list.add("LagunaPresa");
        list.add("intptr-t");
        list.add("s-hosoai");
        list.forEachIf(System.out::println, s -> !s.contains("-"));
    }
}
