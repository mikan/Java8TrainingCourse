/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */
package local.js8ri.ch09.ex01;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Try with resources by old style.
 *
 * @author mikan
 */
public class TryWithResources {

    private static final Logger LOG = Logger.getLogger(TryWithResources.class.getSimpleName());

    public static void main(String[] args) throws Throwable {
        Scanner in = null;
        PrintWriter out = null;
        try {
            in = new Scanner(new File("../README.md"));
            out = new PrintWriter(new File("build/ch9.ex01.txt"));
            while (in.hasNext()) {
                out.println(in.next().toLowerCase());
            }
        } catch (Throwable ex) {
            LOG.severe(ex.getMessage());
            throw ex;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Throwable e) {
                    LOG.log(Level.SEVERE, "Closing failed.", e);
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (Throwable e) {
                    LOG.log(Level.SEVERE, "Closing failed.", e);
                }
            }
        }
    }
}
