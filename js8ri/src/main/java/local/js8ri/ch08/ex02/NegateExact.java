/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch08.ex02;

/**
 * Created by mikan on 2015/09/16.
 *
 * @author mikan
 */
public class NegateExact {

    public static boolean collectNegateExactError(int value) {
        try {
            int result = Math.negateExact(value);
            System.out.println("result: " + result);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    private NegateExact() {

    }
}
