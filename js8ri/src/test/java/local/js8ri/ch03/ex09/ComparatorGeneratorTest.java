/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch03.ex09;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertTrue;

/**
 * @author mikan
 */
public class ComparatorGeneratorTest {

    @Test
    public void testLexicographicComparator_normalInput() {
        Comparator<TestObject> cmp1 = ComparatorGenerator.lexicographicComparator("lastName", "firstName");
        assertTrue(cmp1.compare(new TestObject("A", "B"), new TestObject("A", "B")) == 0);
        assertTrue(cmp1.compare(new TestObject("A", "B"), new TestObject("B", "B")) < 0);
        assertTrue(cmp1.compare(new TestObject("B", "B"), new TestObject("A", "B")) > 0);
        Comparator<TestObject> cmp2 = ComparatorGenerator.lexicographicComparator("firstName", "lastName");
        assertTrue(cmp2.compare(new TestObject("C", "D"), new TestObject("C", "D")) == 0);
        assertTrue(cmp2.compare(new TestObject("C", "D"), new TestObject("D", "D")) < 0);
        assertTrue(cmp2.compare(new TestObject("D", "D"), new TestObject("C", "D")) > 0);
    }


    public static class TestObject {

        public String firstName;
        public String lastName;

        public TestObject(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }
}

