/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch01.ex04;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeThat;

/**
 * @author mikan
 */
public class DirectoryFirstListerTest {

    @Test(expected = NullPointerException.class)
    public void testListFiles_NPE() {
        new DirectoryFirstLister().listFiles(null);
    }

    @Test
    public void testListFiles_normalInput() {
        List<File> files = new DirectoryFirstLister().listFiles("./");
        List<String> fileNames = Arrays.asList(files.stream().map(File::getName).toArray(String[]::new));
        assumeThat(fileNames, hasItem(containsString("js8ri")));
        assumeThat(fileNames, hasItem(containsString(".gradle")));
        assertTrue(files.get(0).isDirectory());
        assertTrue(!files.get(files.size() - 1).isDirectory());
    }
}
