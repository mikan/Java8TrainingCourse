/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch09.ex05;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mikan
 */
public class ReverseReadWrite {

    public static void main(String[] args) {

        try {
            byte[] source = Files.readAllBytes(Paths.get(new File("README.md").toURI()));
            byte[] reversed = new byte[source.length];
            for (int i = source.length - 1; i >= 0; i--) {
                reversed[source.length - 1 - i] = source[i];
            }
            Files.write(Paths.get(new File("out/ch9.ex05.txt").toURI()), reversed);
        } catch (IOException ex) {
            Logger.getLogger(ReverseReadWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
