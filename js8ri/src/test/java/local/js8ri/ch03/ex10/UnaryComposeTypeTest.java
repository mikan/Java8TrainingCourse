/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex10;

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
public class UnaryComposeTypeTest {

    private static Image image;

    @BeforeClass
    public static void initImage() {
        image = new WritableImage(100, 100);
    }

    @Test
    public void testTransform_normalInput() {
        Image result = UnaryComposeType.transform(image, Color::darker);
        assertNotNull(result);
        assertNotEquals(result, image);
    }
}
