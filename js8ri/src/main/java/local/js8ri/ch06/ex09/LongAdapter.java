/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch06.ex09;

/**
 * A {@link ComputableNumber} adapter for long values.
 *
 * @author mikan
 */
public class LongAdapter extends ComputableNumber {

    private static final long serialVersionUID = 1L;

    public LongAdapter(long value) {
        super(value);
    }

    @Override
    public ComputableNumber multiply(ComputableNumber number) {
        return new LongAdapter(longValue() * number.longValue());
    }

    @Override
    public ComputableNumber add(ComputableNumber number) {
        return new LongAdapter(longValue() + number.longValue());
    }
}