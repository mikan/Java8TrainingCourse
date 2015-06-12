/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch01.ex11;

/**
 *
 * @author mikan
 */
public class IAndJ {

    public static void main(String[] args) {
        // IAndJImpl1 impl = new IAndJImpl1();
        // ERROR: staticでない変数 thisをstaticコンテキストから参照することはできません

    }

    public interface NormalI {
        public void f();
    }

    public interface NormalJ {
        public void f();
    }

    public interface StaticI {
        public default void f() {
        }
    }

    public interface staticJ {
        public default void f() {
        }
    }

    public class IAndJImpl1 implements NormalI, NormalJ {

        @Override
        public void f() {
            System.out.println("This is f()");
        }
    }
}
