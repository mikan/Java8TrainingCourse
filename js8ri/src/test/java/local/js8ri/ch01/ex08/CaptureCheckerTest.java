/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch01.ex08;

import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * @author mikan
 */
public class CaptureCheckerTest {

    @Test
    public void testSamples() {
        try {
            CaptureChecker.sample1();
            CaptureChecker.sample2();
            CaptureChecker.sample3();
            /*
            [sample1]Peter
            [sample1]Paul
            [sample1]Mary
            [sample2]Peter
            [sample2]Paul
            [sample2]Mary
            [sample3]Peter
            [sample3]Paul
            [sample3]Mary
             */
        } catch (Exception e) {
            fail();
        }
    }
}
