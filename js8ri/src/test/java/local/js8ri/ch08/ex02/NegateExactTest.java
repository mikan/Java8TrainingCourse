/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch08.ex02;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by mikan on 2015/09/16.
 *
 * @author mikan
 */
public class NegateExactTest {

    @Test
    public void testDoTryNagateExactError() {
        assertTrue(NegateExact.collectNegateExactError(Integer.MIN_VALUE));
        assertFalse(NegateExact.collectNegateExactError(0));
        assertFalse(NegateExact.collectNegateExactError(Integer.MAX_VALUE));
    }
}
