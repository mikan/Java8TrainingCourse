/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch09.ex07;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author mikan
 */
public class UrlRetriever {

    private static final Logger LOG = Logger.getLogger(UrlRetriever.class.getName());
    private static final String DEFAULT_URL = "https://github.com/mikan/Java8TrainingCourse/blob/master/README.md";

    public static void main(String[] args) throws IOException {
        String target = DEFAULT_URL;
        if (args != null && args.length > 0) {
            target = args[0];
        }
        new UrlRetriever().retrieve(new URL(target), Paths.get("js8ri/build/ch9.ex07.txt"));
    }

    public void retrieve(@Nonnull URL from, @Nonnull Path to) throws IOException {
        Objects.requireNonNull(from);
        Objects.requireNonNull(to);
        try (InputStream input = from.openStream()) {
            Files.copy(input, to, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
