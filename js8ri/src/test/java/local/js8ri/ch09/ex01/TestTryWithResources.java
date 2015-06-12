/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch09.ex01;

import java.io.File;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Test for {@link TryWithResources}.
 *
 * @author mikan
 */
public class TestTryWithResources {

    @Test
    public void testMain_emptyInput() throws Throwable {
        TryWithResources.main(null); // Check exception
        File file = new File("build/ch9.ex01.txt");
        assertTrue(file.exists());
    }
}
