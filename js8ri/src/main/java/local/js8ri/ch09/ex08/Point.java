/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */
package local.js8ri.ch09.ex08;

/**
 * The Point class.
 *
 * @author mikan
 */
public class Point implements Comparable<Point> {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point other) {
        if (x == other.x) {
            if (y == other.y) {
                return 0;
            }
            return y > other.y ? 1 : -1;
        }
        return x > other.x ? 1 : -1;
    }

    public int unsafeCompareTo(Point other) {
        int diff = x - other.x;
        if (diff != 0) {
            return diff;
        }
        return y - other.y;
    }

    public int safeCompareTo(Point other) {
        int diff = Integer.compare(x, other.x);
        if (diff != 0) {
            return diff;
        }
        return Integer.compare(y, other.y);
    }
}
