/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */
package local.js8ri.ch02.ex06;

import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author mikan
 */
public class CharacterStreamTest {

    @Test
    public void testAAA() {
        String value = "test";
        Stream<Character> result1 = CharacterStream.characterStream(value);
        Stream<Character> result2 = CharacterStream.characterStream2(value);
        assertNotNull(result1);
        assertNotNull(result2);
        assertArrayEquals(result1.toArray(), result2.toArray());
    }
}
