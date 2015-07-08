/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch02.ex02;

/**
 * @author mikan
 */
public class FilterBehavior {

    private int cursor = 0;

    public void print(boolean result) {
        System.out.print(result ? "#" : ".");
        cursor++;
        if (cursor >= 80) {
            System.out.println();
            cursor = 0;
        }
    }
}
