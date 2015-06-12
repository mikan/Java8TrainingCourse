/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch01.ex08;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mikan
 */
public class CaptureChecker {

    public static void main(String[] args) {
        sample1();
        sample2();
        sample3();
    }

    private static void sample1() {
        String[] names = {"Peter", "Paul", "Mary"};
        List<Runnable> runners = new ArrayList<>();
        for (String name : names) {
            runners.add(() -> System.out.println("[sample1]" + name));
        }
        runners.forEach(run -> new Thread(run).start());
    }

    private static void sample2() {
        String[] names = {"Peter", "Paul", "Mary"};
        List<Runnable> runners = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            runners.add(() -> System.out.println("[sample2]" + name));
        }
        runners.forEach(run -> new Thread(run).start());
    }

    private static void sample3() {
        String[] names = {"Peter", "Paul", "Mary"};
        List<Runnable> runners = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            int j = i;
            runners.add(() -> System.out.println("[sample3]" + names[j]));
        }
        runners.forEach(run -> new Thread(run).start());
    }
}
