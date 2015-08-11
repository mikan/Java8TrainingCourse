/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex08;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import local.js8ri.ch03.ex10.UnaryComposeType;
import local.js8ri.rules.JavaFXThreadingRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author mikan
 */
public class UnaryComposeTypeTest {

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
    public void testTransform_normalInput() {
        Image result = UnaryComposeType.transform(image, Color::darker);
        assertNotNull(result);
        assertNotEquals(result, image);
    }
}
