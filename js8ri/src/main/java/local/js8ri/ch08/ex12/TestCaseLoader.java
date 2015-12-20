/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch08.ex12;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author mikan
 */
public class TestCaseLoader {

    public static void main(String[] args) throws ReflectiveOperationException {
        Class<?> cls = Class.forName("local.js8ri.ch08.ex12.SampleTestCase");
        Object obj = cls.newInstance();
        int count = 0;
        for (Method m : cls.getMethods()) {
            for (Annotation a : m.getAnnotations()) {
                if (a.annotationType() == TestCase.class) {
                    count++;
                    System.out.println(m.getName() + " method: " + m.invoke(obj, 1));
                }
            }
        }
        System.out.println("Invoked " + count + " method(s).");
    }
}
