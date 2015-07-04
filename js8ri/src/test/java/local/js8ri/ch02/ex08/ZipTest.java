/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch02.ex08;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author mikan
 */
@RunWith(Theories.class)
public class ZipTest {

    @DataPoints
    public static int[] numOfStreams = {0, 1, 10, 100};

    @Test(expected = NullPointerException.class)
    public void testZip_firstNPE() {
        Zip.zip(null, Stream.empty());
    }

    @Test(expected = NullPointerException.class)
    public void testZip_secondNPE() {
        Zip.zip(null, null);
    }

    @Theory
    public void testZip_normalInput(int numOfFirst, int numOfSecond) {
        String prefixFirst = "first-";
        String prefixSecond = "second-";
        Stream<String> first = IntStream.range(0, numOfFirst).mapToObj(i -> prefixFirst + i);
        Stream<String> second = IntStream.range(0, numOfSecond).mapToObj(i -> prefixSecond + i);
        Stream<String> result = Zip.zip(first, second);
        String[] dumped = result.toArray(String[]::new);
        assertEquals(numOfFirst + numOfSecond, dumped.length);
        if (dumped.length > 0) {
            // Check head
            assertTrue(numOfFirst == 0 ? dumped[0].startsWith(prefixSecond) : dumped[0].startsWith(prefixFirst));
            // Check tail
            assertTrue(numOfFirst > numOfSecond ? dumped[dumped.length - 1].startsWith(prefixFirst) :
                    dumped[dumped.length - 1].startsWith(prefixSecond));
        }
    }
}
