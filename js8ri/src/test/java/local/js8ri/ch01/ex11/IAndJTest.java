/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch01.ex11;

import local.js8ri.ch01.ex11.IAndJ.IAndJImpl3;
import local.js8ri.ch01.ex11.IAndJ.IAndJImpl4;
import org.junit.Test;

/**
 * @author mikan
 */
public class IAndJTest {

    @Test
    public void testF() {
        // IAndJImpl1 impl1 = new IAndJImpl1();
        // ERROR: staticでない変数 thisをstaticコンテキストから参照することはできません
        // IAndJImpl2 impl2 = new IAndJImpl2();
        // ERROR: staticでない変数 thisをstaticコンテキストから参照することはできません
        IAndJImpl3 impl3 = new IAndJImpl3();
        impl3.f();
        IAndJImpl4 impl4 = new IAndJImpl4();
        impl4.f();
    }
}
