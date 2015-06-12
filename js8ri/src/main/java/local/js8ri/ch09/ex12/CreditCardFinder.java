/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch09.ex12;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find credit card numbers from home directory.
 *
 * Sample output:
 * <pre>
 * 5678-5678-5678-5678 (C:\Users\yutaka\test2.txt)
 * 9999-9999-9999-9999 (C:\Users\yutaka\Downloads\test3.txt)
 * 1234-1234-1234-1234 (C:\Users\yutaka\test.txt)
 * </pre>
 *
 * @author mikan
 */
public class CreditCardFinder {

    private static final String FINDSTR_REGEXP = "\"[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]-[0-9]\""; // findstr has character length limitation.
    private static final String FINDSTR_SUFFIX = "\\*.txt";

    public Map<String, String> find(String path) throws IOException {
        return find(path, true, true);
    }

    public Map<String, String> find(String path, boolean findSubFolder, boolean ignoreCase) throws IOException {
        // Prepare
        File temp = File.createTempFile("CreditCardFinder", ".txt");
        System.out.println("PATH: " + path + ", SUFFIX: " + FINDSTR_SUFFIX);
        List<String> params = new ArrayList<>();
        params.add("findstr");
        if (findSubFolder) {
            params.add("/s");
        }
        if (ignoreCase) {
            params.add("/i");
        }
        params.add(FINDSTR_REGEXP);
        params.add(path + FINDSTR_SUFFIX);
        ProcessBuilder builder = new ProcessBuilder(params);
        builder.redirectOutput(temp);
        // Execute
        try {
            Process process = builder.start();
            process.waitFor();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        // Load result
        List<String> lines = Files.readAllLines(temp.toPath());
        // Remove temp file
        Files.delete(temp.toPath());
        // Parse result
        Map<String, String> result = new HashMap<>(lines.size());
        lines.stream().filter(line -> (line.contains(":"))).forEach(line -> {
            int splitPos = line.lastIndexOf(':');
            String file = line.substring(0, splitPos);
            String card = line.substring(splitPos + 1);
            result.put(file, card);
        });
        return result;
    }
}
