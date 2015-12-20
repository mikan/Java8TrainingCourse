/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch03.ex14;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author mikan
 */
public class LatentImageTest {

    @Test
    public void testToImage_normalInput() {
        LatentImage latentImage = LatentImage.from(new WritableImage(100, 100));
        Image image = latentImage.getImage();
        assertNotNull(image);
    }

    @Test
    public void testTransform_normalInput() {
        LatentImage latentImage = LatentImage.from(new WritableImage(100, 100));
        LatentImage transformed = latentImage.transform((Color::brighter));
        assertNotEquals(latentImage.toImage(), transformed.toImage());
    }
}
