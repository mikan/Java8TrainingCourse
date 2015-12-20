/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch01.ex11;

import org.junit.Test;

/**
 * @author mikan
 */
public class IAndJTest {

    @Test
    public void testF_noExceptionsExpected() {
        new IAndJ().f();
        StaticI.f();
        StaticJ.f();
        new IAndDefaultJ().f();
        new IAndStaticJ().f();
        new DefaultIAndDefaultJ().f();
        new DefaultIAndStaticJOverride().f();
        new DefaultIAndStaticJNoOverride().f(); // DefaultI.f()

        // Construct only
        new StaticIAndStaticJ();
    }

    private static class IAndJ implements I, J {

        @Override
        public void f() {
            System.out.println("IAndJ.f()");
        }
    }

    private static class DefaultIAndDefaultJ implements DefaultI, DefaultJ {
        // Override required
        @Override
        public void f() {
            System.out.println("DefaultIAndDefaultJ.f()");
        }
    }

    private static class StaticIAndStaticJ implements StaticI, StaticJ {
        // Can't override static method
    }

    private static class IAndDefaultJ implements I, DefaultJ {
        // Override required
        @Override
        public void f() {
            System.out.println("IAndDefaultJ.f()");
        }
    }

    private static class IAndStaticJ implements I, StaticJ {
        // Override required
        @Override
        public void f() {
            System.out.println("IAndStaticJ.f()");
        }
    }

    private static class DefaultIAndStaticJOverride implements DefaultI, StaticJ {
        // Override not required
        @Override
        public void f() {
            System.out.println("DefaultIAndStaticJOverride.f()");
        }
    }

    private static class DefaultIAndStaticJNoOverride implements DefaultI, StaticJ {
        // Override not required
    }
}
