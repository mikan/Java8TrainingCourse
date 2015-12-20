/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch06.ex09;

import java.math.BigInteger;

/**
 * A {@link ComputableNumber} adapter for {@link BigInteger} values.
 *
 * @author mikan
 */
public class BigIntegerAdapter extends ComputableNumber {
    private static final long serialVersionUID = 1L;

    public BigIntegerAdapter(BigInteger value) {
        super(value);
    }

    @Override
    public ComputableNumber multiply(ComputableNumber number) {
        return new BigIntegerAdapter(((BigInteger) get()).multiply(((BigInteger) number.get())));
    }

    @Override
    public ComputableNumber add(ComputableNumber number) {
        return new BigIntegerAdapter(((BigInteger) get()).add(((BigInteger) number.get())));
    }
}
