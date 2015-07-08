/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch01.ex11;

/**
 * @author mikan
 */
public class IAndJ {

    private IAndJ() {
        // no content in parent
    }

    public interface NormalI {
        void f();
    }

    public interface NormalJ {
        void f();
    }

    public interface StaticI {
        default void f() {
            System.out.println("This is StaticI.f()");
        }
    }

    public interface StaticJ {
        default void f() {
            System.out.println("This is StaticJ.f()");
        }
    }

    public class IAndJImpl1 implements NormalI, NormalJ {

        @Override
        public void f() {
            System.out.println("This is IAndJImpl1.f()");
        }
    }

    public class IAndJImpl2 implements StaticI, StaticJ {

        @Override
        public void f() {
            System.out.println("This is IAndJImpl2.f()");
        }
    }

    public static class IAndJImpl3 implements NormalI, NormalJ {

        @Override
        public void f() {
            System.out.println("This is IAndJImpl3.f()");
        }
    }

    public static class IAndJImpl4 implements StaticI, StaticJ {

        @Override
        public void f() {
            System.out.println("This is IAndJImpl4.f()");
        }
    }
}
