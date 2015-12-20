/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch01.ex11;

/**
 * @author mikan
 */
public interface DefaultI {
    default void f() {
        System.out.println("DefaultI.f()");
    }
}