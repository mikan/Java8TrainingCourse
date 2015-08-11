/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex06;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
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
    public void testTransform_normalUnaryOperatorInput() {
        Image result = TransformerApp.transform(image, Color::brighter);
        assertNotNull(result);
        assertNotEquals(result, image);
    }

    @Test
    public void testTransform_normalColorTransformerInput() {
        Image result = TransformerApp.transform(image, (x, y, c) ->
                x < 10 || x > image.getWidth() - 10 || y < 10 || y > image.getHeight() - 10 ? Color.GRAY : c);
        assertNotNull(result);
        assertNotEquals(result, image);
    }

    @Test
    public void testTransform_normalBiFunctionInput() {
        Image result = TransformerApp.transform(image, (color, arg) -> arg ? color.invert() : color, true);
        assertNotNull(result);
        assertNotEquals(result, image);
    }
}
