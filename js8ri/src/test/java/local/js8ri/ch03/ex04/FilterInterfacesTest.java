/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch03.ex04;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

/**
 * @author mikan
 */
public class FilterInterfacesTest {

    @Test
    public void testGetFilterFunctionalInterfaces() throws IOException {
        FilterInterfaces fi = new FilterInterfaces();
        Class[] classes = fi.getFilterFunctionalInterfaces();
        assertNotNull(classes);
    }
}
