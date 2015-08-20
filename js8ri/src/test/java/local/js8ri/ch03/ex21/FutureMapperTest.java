/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex21;

import org.junit.Test;

import java.util.concurrent.Future;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

/**
 * @author mikan
 */
public class FutureMapperTest {

    @Test
    public void testMap_normalInput() {
        Future mockFuture = mock(Future.class);
        Future result = FutureMapper.map(mockFuture, Object::toString);
        assertNotNull(result);
    }

    @Test(expected = NullPointerException.class)
    public void testMap_1stNPE() {
        FutureMapper.map(null, String::length);
    }

    @Test(expected = NullPointerException.class)
    public void testMap_2ndNPE() {
        Future mockFuture = mock(Future.class);
        FutureMapper.map(mockFuture, null);
    }
}
