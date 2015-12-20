/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch08.ex15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * @author mikan
 */
public class Grep {

    public static void main(String[] args) throws IOException {
        Predicate<String> predicate = Pattern.compile("^### (.+)").asPredicate();
        Files.lines(Paths.get("README.md")).filter(predicate).forEach(System.out::println);
    }
}
