/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch03.ex07;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

/**
 * @author mikan
 */
@RunWith(Theories.class)
public class ComparatorGeneratorTest {

    @DataPoint
    public static String[] empty = {};

    @DataPoint
    public static String[] single = {"aaa"};

    @DataPoint
    public static String[] normal = {"aaa", "aab", "aa a", "aa b", "aaA", "aaB", "aA a", "aA b"};

    /**
     * naturalOrder: {@code true}, caseSensitive: {@code true} and acceptSpace: {@code true}
     * <p>Normal input result:</p>
     * <pre>
     * [TTT] aA a
     * [TTT] aA b
     * [TTT] aa a
     * [TTT] aa b
     * [TTT] aaA
     * [TTT] aaB
     * [TTT] aaa
     * [TTT] aab
     * </pre>
     *
     * @param input theory input
     */
    @Theory
    public void testGenerate_TrueTrueTrue(String[] input) {
        String[] data = input.clone();
        Arrays.sort(data, ComparatorGenerator.generate(true, true, true));
        Stream.of(data).forEach(d -> System.out.println("[TTT] " + d));
        assumeTrue(data.length >= 2);
        assertTrue(isNaturalOrdered(data, true, true));
    }

    /**
     * naturalOrder: {@code true}, caseSensitive: {@code false} and acceptSpace: {@code false}
     * <p>Normal input result:</p>
     * <pre>
     * [TFF] aaa
     * [TFF] aa a
     * [TFF] aaA
     * [TFF] aA a
     * [TFF] aab
     * [TFF] aa b
     * [TFF] aaB
     * [TFF] aA b
     * </pre>
     *
     * @param input theory input
     */
    @Theory
    public void testGenerate_TrueFalseFalse(String[] input) {
        String[] data = input.clone();
        Arrays.sort(data, ComparatorGenerator.generate(true, false, false));
        Stream.of(data).forEach(d -> System.out.println("[TFF] " + d));
        assumeTrue(data.length >= 2);
        assertTrue(isNaturalOrdered(data, false, false));
    }

    /**
     * naturalOrder: {@code false}, caseSensitive: {@code false} and acceptSpace: {@code false}
     * <p>Normal input result:</p>
     * <pre>
     * [FFF] aab
     * [FFF] aa b
     * [FFF] aaB
     * [FFF] aA b
     * [FFF] aaa
     * [FFF] aa a
     * [FFF] aaA
     * [FFF] aA a
     * </pre>
     *
     * @param input theory input
     */
    @Theory
    public void testGenerate_FalseFalseFalse(String[] input) {
        String[] data = input.clone();
        Arrays.sort(data, ComparatorGenerator.generate(false, false, false));
        Stream.of(data).forEach(d -> System.out.println("[FFF] " + d));
        assumeTrue(data.length >= 2);
        assertFalse(isNaturalOrdered(data, false, false));
    }

    private boolean isNaturalOrdered(@Nonnull String[] array, boolean caseSensitive, boolean acceptSpace) {
        if (array.length < 2) {
            throw new IllegalArgumentException("input size too short: " + array.length);
        }
        String head = acceptSpace ? array[0] : array[0].replaceAll(" ", "");
        String tail = acceptSpace ? array[array.length - 1] : array[array.length - 1].replaceAll(" ", "");
        if ((caseSensitive ? head.compareTo(tail) : head.compareToIgnoreCase(tail)) <= 0) {
            return true;
        }
        return false;
    }
}
