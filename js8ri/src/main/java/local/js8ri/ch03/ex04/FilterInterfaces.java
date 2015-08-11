/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex04;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author mikan
 */
public class FilterInterfaces {

    /*
    Result:
        Interface: java.io.FileFilter
        Method: public abstract boolean java.io.FileFilter.accept(java.io.File)
        Interface: java.io.FilenameFilter
        Method: public abstract boolean java.io.FilenameFilter.accept(java.io.File,java.lang.String)
        Interface: java.util.logging.Filter
        Method: public abstract boolean java.util.logging.Filter.isLoggable(java.util.logging.LogRecord)

    Predicate:
        boolean test(T t)

    Note:
        Each functional interfaces has a boolean method, but FilenameFilter's method has two arguments.
    */
    public static void main(String[] args) throws IOException {
        Stream.of(new FilterInterfaces().getFilterFunctionalInterfaces()).forEach(c -> {
            System.out.println("Interface: " + c.getName());
            System.out.println("Method: " + c.getMethods()[0].toString());
        });
    }

    @Nonnull
    public Class[] getFilterFunctionalInterfaces() throws IOException {
        List<String> lines = new ArrayList<>();
        lines.addAll(retrieveUrl("http://docs.oracle.com/javase/8/docs/api/allclasses-frame.html"));
        lines.addAll(retrieveUrl("http://docs.oracle.com/javase/8/javafx/api/allclasses-frame.html"));
        lines.addAll(retrieveUrl("http://docs.oracle.com/javaee/7/api/allclasses-frame.html"));
        return lines.stream()
                .filter(s -> s.contains("interfaceName"))
                .map(this::getName)
                .filter(s -> s.contains("Filter"))
                .map(this::getClass)
                .flatMap(c -> c.isPresent() ? Stream.of(c.get()) : Stream.empty())
                .filter(c -> c.isAnnotationPresent(FunctionalInterface.class))
                .toArray(Class[]::new);
    }

    @Nonnull
    private List<String> retrieveUrl(@Nonnull String url) throws IOException {
        List<String> lines = new ArrayList<>();
        try (InputStream input = new URL(url).openStream()) {
            Scanner scanner = new Scanner(input);
            scanner.useDelimiter("\\n");
            while (scanner.hasNext()) {
                lines.add(scanner.next());
            }
        }
        return lines;
    }

    @Nonnull
    private String getName(@Nonnull String line) {
        return line.substring(line.indexOf("\"") + 1, line.indexOf(".html")).replaceAll("/", ".");
    }

    @Nonnull
    private Optional<Class> getClass(@Nonnull String name) {
        try {
            return Optional.of(Class.forName(name));
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException: " + name);
            return Optional.empty();
        }
    }
}