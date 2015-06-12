/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch09.ex07;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mikan
 */
public class UrlRetriever {

    private static final Logger LOG = Logger.getLogger(UrlRetriever.class.getName());

    public static void main(String[] args) {
        String target = "https://github.com/Java8Workshop/About/blob/master/README.md";
        if (args != null && args.length > 0) {
            target = args[0];
        }
        try (InputStream input = new URL(target).openStream()) {
            Files.copy(input, Paths.get("out/ch9.ex07.txt"), StandardCopyOption.REPLACE_EXISTING);
        } catch (MalformedURLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }
}
