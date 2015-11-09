/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch08.ex09;

import java.util.*;
import java.util.stream.*;

/**
 * @author mikan
 * @see "http://hg.openjdk.java.net/jdk8/jdk8/jdk/file/687fd7c7986d/src/share/classes/java/io/BufferedReader.java#l561"
 */
public class ScannerConverter {

    public static Stream<String> wordStream(Scanner scanner) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(new Iterator<String>() {
            @Override
            public String next() {
                return scanner.next();
            }

            @Override
            public boolean hasNext() {
                return scanner.hasNext();
            }
        }, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }

    public static Stream<String> lineStream(Scanner scanner) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(new Iterator<String>() {
            @Override
            public String next() {
                return scanner.nextLine();
            }

            @Override
            public boolean hasNext() {
                return scanner.hasNextLine();
            }
        }, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }

    public static IntStream intStream(Scanner scanner) {
        return StreamSupport.intStream(Spliterators.spliteratorUnknownSize(new PrimitiveIterator.OfInt() {
            @Override
            public int nextInt() {
                return scanner.nextInt();
            }

            @Override
            public boolean hasNext() {
                return scanner.hasNextInt();
            }
        }, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }

    public static DoubleStream doubleStream(Scanner scanner) {
        return StreamSupport.doubleStream(Spliterators.spliteratorUnknownSize(new PrimitiveIterator.OfDouble() {
            @Override
            public double nextDouble() {
                return scanner.nextDouble();
            }

            @Override
            public boolean hasNext() {
                return scanner.hasNextInt();
            }
        }, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }

    public static void main(String[] args) {
        System.out.println("wordStream:   " + wordStream(createSource()).collect(Collectors.joining(" / ")));
        System.out.println("lineStream:   " + lineStream(createSource()).collect(Collectors.joining(" / ")));
        System.out.println("intStream:    " + intStream(createSource()).mapToObj(Integer::toString).collect(Collectors.joining(" / ")));
        System.out.println("doubleStream: " + doubleStream(createSource()).mapToObj(Double::toString).collect(Collectors.joining(" / ")));
    }

    private static Scanner createSource() {
        String br = System.getProperty("line.separator");
        return new Scanner("1 2 3 4 5" + br + "6 7 8 9 10" + br);
    }

    private ScannerConverter() {
        // static use only
    }
}
