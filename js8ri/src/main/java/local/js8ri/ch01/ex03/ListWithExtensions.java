/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */
package local.js8ri.ch01.ex03;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mikan
 */
public class ListWithExtensions {

    public static void main(String[] args) {
        new ListWithExtensions().getFilesByExtension(System.getProperty("user.home"), ".txt").forEach(System.out::println);
    }

    public List<String> getFilesByExtension(String path, String ext) {
        Objects.requireNonNull(path);
        Objects.requireNonNull(ext);
        File dir = new File(path);
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("Not a directory: " + dir);
        }
        List<String> list = Arrays.asList(dir.list((file, name) -> {
            return file.exists() && name.endsWith(ext); // "ext" captured.
        }));
        return list;
    }
}
