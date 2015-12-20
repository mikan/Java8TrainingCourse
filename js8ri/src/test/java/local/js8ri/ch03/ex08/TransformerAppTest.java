/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch03.ex08;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author mikan
 */
public class TransformerAppTest {

    private static final int IMAGE_WIDTH = 100;
    private static final int IMAGE_HEIGHT = 100;
    private static Image image;

    @BeforeClass
    public static void initImage() {
        image = new WritableImage(IMAGE_WIDTH, IMAGE_HEIGHT);
    }

    @Test
    public void testTransform_normalColorTransformerInput() {
        Image result = TransformerApp.transform(image, TransformerApp.createBorder(image, 10, Color.GRAY));
        assertNotNull(result);
        assertNotEquals(result, image);
    }

    @Test
    public void testCreateBorder_normalInput() {
        TransformerApp.ColorTransformer transformer = TransformerApp.createBorder(image, 10, Color.GRAY);
        assertNotNull(transformer);
        assertEquals(Color.GRAY, transformer.apply(0, 0, Color.BLACK));
        assertEquals(Color.GRAY, transformer.apply(0, IMAGE_HEIGHT - 1, Color.BLACK));
        assertEquals(Color.GRAY, transformer.apply(IMAGE_WIDTH - 1, 0, Color.BLACK));
        assertEquals(Color.GRAY, transformer.apply(IMAGE_WIDTH - 1, IMAGE_HEIGHT - 1, Color.BLACK));
        assertEquals(Color.BLACK, transformer.apply(IMAGE_WIDTH / 2, IMAGE_HEIGHT / 2, Color.BLACK));
    }
}
