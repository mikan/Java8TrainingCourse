/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch02.ex08;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author mikan
 */
public class Zip {

    private static final boolean parallel = false;

    private Zip() {

    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Objects.requireNonNull(first);
        Objects.requireNonNull(second);
        // Create a "spliterator" (Split-iterator).
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
                new ZipIterator<>(first.iterator(), second.iterator()),
                Spliterator.ORDERED | Spliterator.IMMUTABLE | Spliterator.NONNULL), parallel);
    }

    private static class ZipIterator<T> implements Iterator<T> {

        private final AtomicBoolean firstTurn = new AtomicBoolean(true);
        private final Iterator<T> first;
        private final Iterator<T> second;

        public ZipIterator(Iterator<T> first, Iterator<T> second) {
            Objects.requireNonNull(first);
            Objects.requireNonNull(second);
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean hasNext() {
            return first.hasNext() || second.hasNext();
        }

        @Override
        public T next() {
            return firstTurn.getAndSet(!firstTurn.get()) ?
                    (first.hasNext() ? first.next() : second.next()) :
                    (second.hasNext() ? second.next() : first.next());
        }
    }
}
