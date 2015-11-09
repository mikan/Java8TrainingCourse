/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch08.ex12;

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
}
