/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch04.ex01;

import javafx.application.Platform;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assume.assumeFalse;

/**
 * @author mikan
 */
public class HelloJavaFxTest {

    @Test
    public void testStart_invokeOnly() throws Exception {
        assumeFalse(GraphicsEnvironment.isHeadless());
        // not testable...
        Platform.exit();
    }
}
