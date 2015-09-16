/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch08.ex01;

/**
 * Created by mikan on 2015/09/16.
 *
 * @author mikan
 */
public class UnsignedInt {

    private final int value;

    public UnsignedInt() {
        value = 0;
    }

    public UnsignedInt(int value) {
        this.value = value;
    }

    public long add(int value) {
        return Integer.toUnsignedLong(this.value) + Integer.toUnsignedLong(value);
    }

    public long sub(int value) {
        return Integer.toUnsignedLong(this.value) - Integer.toUnsignedLong(value);
    }

    public int div(int value) {
        return Integer.divideUnsigned(this.value, value);
    }

    public int compare(int value) {
        return Long.compare(Integer.toUnsignedLong(this.value), Integer.toUnsignedLong(value));
    }

    public int getIntValue() {
        return value;
    }
}
