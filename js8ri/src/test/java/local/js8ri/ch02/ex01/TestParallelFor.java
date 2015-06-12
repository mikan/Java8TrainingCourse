/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch02.ex01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author mikan
 */
public class TestParallelFor {


    @Test
    public void testCounts() throws IOException {
        ParallelFor.fetchAliceDotTxt();
        String contents = new String(Files.readAllBytes(Paths.get("src/main/res/alice.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        ParallelFor pf1 = new ParallelFor(1, 1);
        assertEquals(pf1.countSequential(words), pf1.countParallel(words));
        ParallelFor pf2 = new ParallelFor(12, 1);
        assertEquals(pf2.countSequential(words), pf2.countParallel(words));
        ParallelFor pf3 = new ParallelFor(1, 100);
        assertEquals(pf3.countSequential(words), pf3.countParallel(words));
    }
}
