/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex13;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author mikan
 */
public class TransformerGeneratorTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCreateBlur_IAE() {
        TransformerGenerator.createBlur(0);
    }

    @Test
    public void testCreateBlur_normalInput() {
        TransformerApp.ColorTransformer transformer = TransformerGenerator.createBlur(10);
        assertNotNull(transformer);
    }

    @Test
    public void testCreateEdgeDetection_normalCall() {
        TransformerApp.ColorTransformer transformer = TransformerGenerator.createEdgeDetection();
        assertNotNull(transformer);
    }
}
