/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch06.ex09;

import java.math.BigInteger;

/**
 * Created by mikan on 2015/09/16.
 *
 * @author mikan
 */
public class Matrix {

    private final ComputableNumber[][] value;

    private Matrix(ComputableNumber[][] value) {
        this.value = value;
    }

    public static Matrix of(long v1, long v2, long v3, long v4) {
        return of(new LongAdapter(v1), new LongAdapter(v2),
                new LongAdapter(v3), new LongAdapter(v4));
    }

    public static Matrix of(BigInteger v1, BigInteger v2, BigInteger v3, BigInteger v4) {
        return of(new BigIntegerAdapter(v1), new BigIntegerAdapter(v2),
                new BigIntegerAdapter(v3), new BigIntegerAdapter(v4));
    }

    private static Matrix of(ComputableNumber v1, ComputableNumber v2,
                             ComputableNumber v3, ComputableNumber v4) {
        ComputableNumber[][] array = {{v1, v2}, {v3, v4}};
        return new Matrix(array);
    }

    public Matrix multiply(Matrix v) {
        return of(
                at(0).multiply(v.at(0)).add(at(2).multiply(v.at(1))),
                at(1).multiply(v.at(0)).add(at(3).multiply(v.at(1))),
                at(0).multiply(v.at(2)).add(at(2).multiply(v.at(3))),
                at(1).multiply(v.at(2)).add(at(3).multiply(v.at(3))));
    }

    public ComputableNumber at(int n) {
        return value[n < value.length ? 0 : 1][n % value.length];
    }
}
