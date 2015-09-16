/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch06.ex07;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.LongStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by mikan on 2015/09/16.
 *
 * @author mikan
 */
public class SearchMaxKeyTest {

    @Test
    public void testFindMaxKey_normalInput() {
        int limit = 1000000;
        ConcurrentHashMap<String, Long> source = new ConcurrentHashMap<>();
        LongStream.rangeClosed(1, limit).forEach(l -> source.put(String.valueOf(l), l));
        String max = SearchMaxKey.findMaxKey(source);
        assertEquals(String.valueOf(limit), max);
    }
}
