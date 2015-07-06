/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch04.ex08;

import java.awt.Dimension;

/**
 * JavaBean adapter of the {@link java.awt.Dimension}.
 *
 * @author mikan
 */
public class DimensionAdapter extends Dimension {

    private static final long serialVersionUID = 1L;

    public void setWidth(double width) {
        setSize(width, getHeight());
    }

    public void setHeight(double height) {
        setSize(getWidth(), height);
    }
}
