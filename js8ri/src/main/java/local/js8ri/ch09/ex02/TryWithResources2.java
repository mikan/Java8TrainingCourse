/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch09.ex02;

import java.io.Closeable;
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
public class TryWithResources2 {

    private static final Logger LOG = Logger.getLogger(TryWithResources2.class.getSimpleName());
    private static Throwable original = null;

    public static void main(String[] args) throws Throwable {
        Scanner in = null;
        PrintWriter out = null;
        try {
            in = new Scanner(new File("../README.md"));
            out = new PrintWriter(new File("build/ch9.ex02.txt"));
            while (in.hasNext()) {
                out.println(in.next().toLowerCase());
            }
        } catch (Throwable ex) {
            LOG.severe(ex.getMessage());
            original = ex;
            throw ex;
        } finally {
            safeClose(in);
            safeClose(out);
        }
    }

    private static void safeClose(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (Throwable e) {
                if (original != null) {
                    original.addSuppressed(e);
                }
                LOG.log(Level.SEVERE, "Closing failed.", e);
            }
        }
    }
}
