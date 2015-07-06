/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch01.ex12;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * @author mikan
 */
public class CompileOldLibraryTest {

    private static final String TARGET_SOURCE = "oldlib/OldLibraryMain.java7";
    private static final String TARGET_CLASS_NAME = "OldLibraryMain";

    @Test(expected = NullPointerException.class)
    public void testCompile_pathNPE() {
        new CompileOldLibrary().compile(null, TARGET_CLASS_NAME);
    }

    @Test(expected = NullPointerException.class)
    public void testCompile_classNameNPE() {
        new CompileOldLibrary().compile(TARGET_SOURCE, null);
    }

    @Test
    public void testCompile_normalInput() {
        boolean success = new CompileOldLibrary().compile(TARGET_SOURCE, TARGET_CLASS_NAME);
        assertFalse(success); // not source-compatible
    }
}
