/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch05.ex07;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.Objects;

/**
 * @author mikan
 */
public class TimeInterval {

    private static final TemporalUnit ZERO_UNIT = ChronoUnit.SECONDS;
    @NonNull
    private final Temporal begin;
    @NonNull
    private final Temporal end;

    /**
     * Constructs the interval between {@code begin} and {@code end}.
     *
     * @param begin begin
     * @param end   end
     * @throws NullPointerException     if specify {@code null}.
     * @throws IllegalArgumentException if specify begin until end.
     */
    public TimeInterval(@NonNull Temporal begin, @NonNull Temporal end) {
        Objects.requireNonNull(begin);
        Objects.requireNonNull(end);
        if (begin.until(end, ZERO_UNIT) < 0) {
            throw new IllegalArgumentException("begin > end!");
        }
        this.begin = begin;
        this.end = end;
    }

    /**
     * Returns crossing or not crossing.
     * <pre>
     * [Cross Case 1: A.begin until B.begin]
     * A #****#      A.end until B.begin
     * B      #****# B.begin until A.end
     *
     * [Cross Case 2: A.begin not until B.begin]
     * A      #****# A.begin until B.end
     * B #****#      B.end until A.begin
     *
     * [Cross Case 3: A.begin equals B.begin]
     * A #****#
     * B #****#     B.begin equals A.begin.
     *
     * [Cross Case 4]
     * A #******#
     * B #****#      B.begin equals A.begin.
     *
     * [Cross Case 5]
     * A #******#
     * B   #****#    B.end equals A.end.
     *
     * [No Cross Case 1: A.begin until B.begin]
     * A #****#
     * B        #****# B.begin until A.end! A.end not until B.begin!
     *
     * [No Cross Case 2: A.begin not until B.begin]
     * A        #****#
     * B #****#
     * </pre>
     *
     * @param other other
     * @return {@code true} if cross this and other, {@code false} otherwise.
     */
    public boolean cross(@Nullable TimeInterval other) {
        if (other == null) {
            return false;
        }
        if (isEmpty() && other.isEmpty()) {
            return false; // empty intervals are not cross.
        }
        if (begin.equals(other.begin) || end.equals(other.end)) {
            return true;
        }
        return begin.until(other.begin, ZERO_UNIT) >= 0 ?
                other.begin.until(end, ZERO_UNIT) > 0 : begin.until(other.end, ZERO_UNIT) > 0;
    }

    /**
     * Returns empty or not empty.
     *
     * @return {@code true} if the interval is empty, {@code false} otherwise.
     */
    public boolean isEmpty() {
        return begin.equals(end);
    }
}
