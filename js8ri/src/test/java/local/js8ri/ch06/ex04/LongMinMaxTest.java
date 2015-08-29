/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch06.ex04;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;
import java.util.stream.LongStream;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author mikan
 */
public class LongMinMaxTest {

    private static final int SOURCE_LENGTH = 1000;
    private static long[] source;

    @BeforeClass
    public static void generateSource() {
        source = new long[SOURCE_LENGTH];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < SOURCE_LENGTH; i++) {
            source[i] = random.nextLong();
        }
        source[0] = Long.MAX_VALUE;
        source[SOURCE_LENGTH - 1] = Long.MIN_VALUE;
    }

    @Test(expected = NullPointerException.class)
    public void testMax_NPE() {
        new LongMinMax().max(null);
    }

    @Test
    public void testMax_normalInput() {
        long max = new LongMinMax().max(LongStream.of(source));
        assertEquals(Long.MAX_VALUE, max);
    }

    @Test(expected = NullPointerException.class)
    public void testMin_NPE() {
        new LongMinMax().min(null);
    }

    @Test
    public void testMin_normalInput() {
        long min = new LongMinMax().min(LongStream.of(source));
        assertEquals(Long.MIN_VALUE, min);
    }
}
