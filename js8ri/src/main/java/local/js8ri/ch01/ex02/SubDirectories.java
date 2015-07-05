/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch01.ex02;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author mikan
 */
public class SubDirectories {

    /**
     * Get a list of sub directories, lambda implementation.
     *
     * @param path path of parent
     * @return list of sub directories
     * @throws NullPointerException if path is {@code null}
     * @throws IllegalArgumentException if path is not a directory or not exist location
     */
    public List<File> getSubDirectories1(String path) {
        return searchSubDirectories1(new ArrayList<>(), pathToDirFile(path));
    }

    /**
     * Get a list of sub directories, File::isDirectory method-ref. implementation.
     *
     * @param path path of parent
     * @return list of sub directories
     * @throws NullPointerException if path is {@code null}
     * @throws IllegalArgumentException if path is not a directory or not exist location
     */
    public List<File> getSubDirectories2(String path) {
        return searchSubDirectories2(new ArrayList<>(), pathToDirFile(path));
    }

    /**
     * Get a list of sub directories, original file filter's method-ref. implementation.
     *
     * @param path path of parent
     * @return list of sub directories
     * @throws NullPointerException if path is {@code null}
     * @throws IllegalArgumentException if path is not a directory or not exist location
     */
    public List<File> getSubDirectories3(String path) {
        return searchSubDirectories3(new ArrayList<>(), pathToDirFile(path));
    }

    private List<File> searchSubDirectories1(List<File> subtotal, File parent) {
        Objects.requireNonNull(subtotal);
        Objects.requireNonNull(parent);
        List<File> subDirs = Arrays.asList(parent.listFiles(f -> f.exists() && f.isDirectory())); // lambda (with exists)
        subtotal.addAll(subDirs);
        subDirs.forEach(d -> searchSubDirectories1(subtotal, d));
        return subtotal;
    }

    private List<File> searchSubDirectories2(List<File> subtotal, File parent) {
        Objects.requireNonNull(subtotal);
        Objects.requireNonNull(parent);
        List<File> subDirs = Arrays.asList(parent.listFiles(File::isDirectory)); // Method ref.
        subtotal.addAll(subDirs);
        subDirs.forEach(d -> searchSubDirectories2(subtotal, d));
        return subtotal;
    }

    private List<File> searchSubDirectories3(List<File> subtotal, File parent) {
        Objects.requireNonNull(subtotal);
        Objects.requireNonNull(parent);
        List<File> subDirs = Arrays.asList(parent.listFiles(new MyFileFilter()::accept)); // Method ref.
        subtotal.addAll(subDirs);
        subDirs.forEach(d -> searchSubDirectories3(subtotal, d));
        return subtotal;
    }

    private static class MyFileFilter implements FileFilter {

        @Override
        public boolean accept(File pathname) {
            return pathname.isDirectory();
        }
    }

    private static File pathToDirFile(String path) {
        Objects.requireNonNull(path);
        File dir = new File(path);
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("Not a directory: " + dir);
        }
        if (!dir.exists()) {
            throw new IllegalArgumentException("Not exist location: " + dir);
        }
        return dir;
    }
}
