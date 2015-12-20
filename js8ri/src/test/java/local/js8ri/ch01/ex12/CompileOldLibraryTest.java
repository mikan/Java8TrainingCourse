/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch01.ex12;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;

/**
 * @author mikan
 */
public class CompileOldLibraryTest {

    private static final String TARGET_SOURCE = "src/main/resources/oldlib/OldLibraryMain.java7";
    private static final String TARGET_CLASS_NAME = "OldLibraryMain";

    @Test(expected = NullPointerException.class)
    public void testCompile_classNameNPE() throws IOException {
        new CompileOldLibrary().compile(TARGET_SOURCE, null);
    }

    @Test
    public void testCompile_normalInput() throws IOException {
        boolean success = new CompileOldLibrary().compile(TARGET_SOURCE, TARGET_CLASS_NAME);
        assertFalse(success); // not source-compatible
    }
}
