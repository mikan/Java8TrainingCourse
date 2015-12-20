/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch06.ex02;

import org.junit.Test;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by mikan on 2015/09/16.
 *
 * @author mikan
 */
public class IdGeneratorTest {

    @Test
    public void testGenerate_rangeCheck() {
        int size = 10000;
        IdGenerator gen = IdGenerator.getInstance();
        long sum = IntStream.range(0, size).parallel().mapToLong(i -> gen.generate()).sum();
        assertEquals(LongStream.rangeClosed(0, size).sum(), sum);
    }
}
