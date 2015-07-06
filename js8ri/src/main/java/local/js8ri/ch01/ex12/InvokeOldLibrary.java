/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch01.ex12;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Objects;

/**
 * @author mikan
 */
public class InvokeOldLibrary {

    public static void main(String[] args) throws MalformedURLException {
        new InvokeOldLibrary().invoke("oldlib/OldLibraryMain.jar", "OldLibraryMain");
    }

    public boolean invoke(String jarPath, String className) throws MalformedURLException {
        Objects.requireNonNull(jarPath);
        Objects.requireNonNull(className);
        ClassLoader loader = URLClassLoader.newInstance(
                new URL[]{getClass().getClassLoader().getResource(jarPath)},
                getClass().getClassLoader()
        );
        try {
            Class<?> clazz = Class.forName(className, true, loader);
            Method method = clazz.getMethod("main", String[].class);
            method.invoke(null, new Object[]{null}); // Success: binary-compatible
            return true;
        } catch (InvocationTargetException e) {
            System.err.println(e.getCause());
        } catch (ReflectiveOperationException e) {
            System.err.println(e);
        }
        return false;
    }
}
