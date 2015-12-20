/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */
package local.js8ri.ch09.ex09;

import java.util.Objects;

/**
 * The LabeledPoint class.
 *
 * @author mikan
 */
public class LabeledPoint {

    private final String label;
    private final int x;
    private final int y;

    public LabeledPoint(int x, int y, String label) {
        this.x = x;
        this.y = y;
        this.label = label;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null) {
            return false;
        }
        if (getClass() != otherObject.getClass()) {
            return false;
        }
        LabeledPoint other = (LabeledPoint) otherObject;
        return Objects.equals(x, other.x) && Objects.equals(y, other.y) && Objects.equals(label, other.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, label);
    }

    public int hashCodeFaster() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.label);
        hash = 43 * hash + this.x;
        hash = 43 * hash + this.y;
        return hash;
    }
}
