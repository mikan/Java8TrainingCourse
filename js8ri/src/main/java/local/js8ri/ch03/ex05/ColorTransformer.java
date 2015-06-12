/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex05;

import javafx.scene.paint.Color;

/**
 * Downloaded from http://horstmann.com/java8/
 */
@FunctionalInterface
public interface ColorTransformer {
    Color apply(int x, int y, Color colorAtXY);
}
