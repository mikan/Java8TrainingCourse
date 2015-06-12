/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch02.ex06;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author mikan
 */
public class CharacterStream {

    private CharacterStream() {

    }

    public static Stream<Character> characterStream(String s) {
        List<Character> result = new ArrayList<>();
        for (char c : s.toCharArray()) {
            result.add(c);
        }
        return result.stream();
    }

    public static Stream<Character> characterStream2(String s) {
        return IntStream.range(0, s.length()).map(s::charAt).mapToObj(i -> (char) i);
    }
}
