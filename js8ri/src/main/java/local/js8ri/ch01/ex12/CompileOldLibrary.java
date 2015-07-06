/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch01.ex12;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author mikan
 */
public class CompileOldLibrary {

    public static void main(String[] args) {
        new CompileOldLibrary().compile("oldlib/OldLibraryMain.java7", "OldLibraryMain");
    }

    public void compile(String path, String className) {
        String source = new Scanner(getClass().getClassLoader().getResourceAsStream(path)).useDelimiter("\\A").next();
        Iterable<String> options = Arrays.asList("-d", "build");
        Iterable<JavaFileObject> units = Collections.singletonList(new MyJavaFileObject(className, source));
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        CompilationTask task = ToolProvider.getSystemJavaCompiler().getTask(null, null, diagnostics, options, null, units);
        boolean success = task.call();
        diagnostics.getDiagnostics().forEach(System.out::println);
        if (success) {
            try {
                Method method = Class.forName(className).getMethod("main", String[].class);
                method.invoke(null, new Object[]{null}); // Fail: source-incompatible
            } catch (ReflectiveOperationException e) {
                System.err.println(e);
            }
        }
    }

    private static class MyJavaFileObject extends SimpleJavaFileObject {

        private final String source;

        public MyJavaFileObject(String name, String source) {
            super(URI.create("string:///" + name + JavaFileObject.Kind.SOURCE.extension),
                    JavaFileObject.Kind.SOURCE);
            this.source = source;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            return source;
        }
    }
}
