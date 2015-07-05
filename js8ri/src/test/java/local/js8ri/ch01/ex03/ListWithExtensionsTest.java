/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch01.ex03;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

/**
 * @author mikan
 */
public class ListWithExtensionsTest {

    @Test(expected = NullPointerException.class)
    public void testGetFilesByExtension_pathNPE() {
        new ListWithExtensions().getFilesByExtension(null, ".java");
    }

    @Test(expected = NullPointerException.class)
    public void testGetFilesByExtension_extNPE() {
        new ListWithExtensions().getFilesByExtension("./", null);
    }

    @Test
    public void testGetFilesByExtension_currentDirectoryInput() {
        List<String> result = new ListWithExtensions().getFilesByExtension("../", ".md");
        assertThat(result, hasItem(containsString("README.md")));
    }
}
