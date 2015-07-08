/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch01.ex05;

/**
 *
 * @author mikan
 */
public class Launcher {

    public static void main(String[] args) {
        System.out.println(new DigitalClockFrame("Digital Clock").getName()); // LOC: 101
        System.out.println(new UpdatedDigitalClockFrame("Digital Clock").getName()); // LOC: 82
    }
}
