/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch09.ex06;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mikan
 */
public class ReverseReadWriteLine {

    public static void main(String[] args) {

        try {
            List<String> lines = Files.readAllLines(Paths.get(new File("README.md").toURI()));
            Collections.reverse(lines);
            Files.write(Paths.get(new File("build/ch9.ex06.txt").toURI()), lines);
        } catch (IOException ex) {
            Logger.getLogger(ReverseReadWriteLine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
