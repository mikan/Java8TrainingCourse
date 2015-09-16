/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch06.ex09;

/**
 * Created by mikan on 2015/09/16.
 *
 * @author mikan
 */
public abstract class ComputableNumber extends Number {

    private static final long serialVersionUID = 1L;
    private final Number number;

    protected ComputableNumber(Number number) {
        this.number = number;
    }

    @Override
    public int intValue() {
        return number.intValue();
    }

    @Override
    public long longValue() {
        return number.longValue();
    }

    @Override
    public float floatValue() {
        return number.floatValue();
    }

    @Override
    public double doubleValue() {
        return number.doubleValue();
    }

    public abstract ComputableNumber multiply(ComputableNumber number);

    public abstract ComputableNumber add(ComputableNumber number);

    protected Number get() {
        return number;
    }
}