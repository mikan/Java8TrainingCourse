/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch01.ex12;

import org.junit.Test;

import java.net.MalformedURLException;

import static org.junit.Assert.assertTrue;

/**
 * @author mikan
 */
public class InvokeOldLibraryTest {

    private static final String TARGET_JAR = "oldlib/OldLibraryMain.jar";
    private static final String TARGET_CLASS_NAME = "OldLibraryMain";

    @Test(expected = NullPointerException.class)
    public void testInvoke_jarNPE() throws MalformedURLException {
        new InvokeOldLibrary().invoke(null, TARGET_CLASS_NAME);
    }

    @Test(expected = NullPointerException.class)
    public void testInvoke_classNameNPE() throws MalformedURLException {
        new InvokeOldLibrary().invoke(TARGET_JAR, null);
    }

    @Test
    public void testInvoke_normalInput() throws MalformedURLException {
        boolean success = new InvokeOldLibrary().invoke(TARGET_JAR, TARGET_CLASS_NAME);
        assertTrue(success); // binary-compatible
    }
}
