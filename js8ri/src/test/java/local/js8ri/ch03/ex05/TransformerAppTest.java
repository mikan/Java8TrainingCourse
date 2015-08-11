/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex05;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import local.js8ri.rules.JavaFXThreadingRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assume.assumeFalse;

/**
 * @author mikan
 */
public class TransformerAppTest {

    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    private static final String IMAGE_URL = "http://www001.upp.so-net.ne.jp/yshibata/myhomepage/images/js8ri.png";
    private Image image;

    @Before
    public void initImage() {
        if (image == null) {
            image = new Image(IMAGE_URL);
        }
    }

    @Test
    public void testTransform_normalUnaryOperatorInput() {
        assumeFalse(javafxRule.isHeadless());
        Image result = TransformerApp.transform(image, Color::brighter);
        assertNotNull(result);
        assertNotEquals(result, image);
    }

    @Test
    public void testTransform_normalColorTransformerInput() {
        assumeFalse(javafxRule.isHeadless());
        Image result = TransformerApp.transform(image, (x, y, c) ->
                x < 10 || x > image.getWidth() - 10 || y < 10 || y > image.getHeight() - 10 ? Color.GRAY : c);
        assertNotNull(result);
        assertNotEquals(result, image);
    }

}
