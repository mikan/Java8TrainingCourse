/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */
package local.js8ri.ch09.ex01;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

/**
 * Test for {@link TryWithResources}.
 *
 * @author mikan
 */
public class TryWithResourcesTest {

    @Test
    public void testMain_emptyInput() throws Throwable {
        TryWithResources.main(null); // Check exception
        File file = new File("build/ch9.ex01.txt");
        assertTrue(file.exists());
    }
}
