/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch03.ex06;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author mikan
 */
public class TransformerAppTest {

    private static Image image;

    @BeforeClass
    public static void initImage() {
        image = new WritableImage(100, 100);
    }

    @Test
    public void testTransform_normalBiFunctionInput() {
        Image result = TransformerApp.transform(image, (color, arg) -> arg ? color.invert() : color, true);
        assertNotNull(result);
        assertNotEquals(result, image);
    }
}
