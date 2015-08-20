/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch04.ex07;

import javafx.application.Platform;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assume.assumeFalse;

/**
 * @author mikan
 */
public class GridPaneAppTest {

    @Test
    public void testStart_invokeOnly() throws Exception {
        assumeFalse(GraphicsEnvironment.isHeadless());
        // not testable...
        Platform.exit();
    }
}
