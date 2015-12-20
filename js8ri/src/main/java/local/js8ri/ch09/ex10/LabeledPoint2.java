/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */
package local.js8ri.ch09.ex10;

import local.js8ri.ch09.ex09.LabeledPoint;

import java.util.Objects;


/**
 * The LabeledPoint2 class.
 *
 * @author mikan
 */
public class LabeledPoint2 extends LabeledPoint implements Comparable<LabeledPoint2> {

    public LabeledPoint2(int x, int y, String label) {
        super(x, y, label);
    }

    @Override
    public int compareTo(LabeledPoint2 other) {
        Objects.requireNonNull(other);
        int diff = Integer.compare(getX(), other.getX());
        if (diff != 0) {
            return diff;
        }
        return Integer.compare(getY(), other.getY());
    }
}
