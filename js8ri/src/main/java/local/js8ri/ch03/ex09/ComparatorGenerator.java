/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex09;

import java.lang.reflect.Field;
import java.util.Comparator;

/**
 * @author mikan
 */
public class ComparatorGenerator {

    private ComparatorGenerator() {
        // static use only
    }

    public static <T> Comparator<T> lexicographicComparator(String... fieldNames) {
        return (first, second) -> {
            for (String fieldName : fieldNames) {
                String firstValue = null, secondValue = null;
                try {
                    Field firstField = first.getClass().getField(fieldName);
                    firstField.setAccessible(true);
                    firstValue = (String) firstField.get(first);
                    Field secondField = second.getClass().getField(fieldName);
                    secondField.setAccessible(true);
                    secondValue = (String) secondField.get(second);
                } catch (ReflectiveOperationException e) {
                    System.err.println("ERROR: " + e);
                    continue;
                }
                if (firstValue != null && secondValue != null) {
                    int compare = firstValue.compareTo(secondValue);
                    System.out.println("Comparing " + firstValue + " : " + secondValue + " -> " + compare);
                    if (compare != 0) {
                        return compare;
                    }
                }
            }
            return 0; // perfect match (or nulls and/or errors contained).
        };
    }
}
