/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch08.ex13;

/**
 * @author mikan
 */
public class SampleTestCase {

    @TestCase
    public int plus(int source) {
        System.out.println("Invoked!");
        return source + 1;
    }

    @TestCase
    public int minus(int source) {
        System.out.println("Invoked!");
        return source - 1;
    }

    public static void main(String[] args) {
        System.out.println("main() invoked.");
        SampleTestCase sample = new SampleTestCase();
        System.out.println("plus(): " + (sample.plus(0) == 1 ? "OK" : "NG"));
        System.out.println("minus(): " + (sample.minus(1) == 0 ? "OK" : "NG"));
    }
}
