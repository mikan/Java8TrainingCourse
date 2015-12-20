/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch02.ex03;

import org.junit.Test;

import java.io.IOException;

/**
 * @author mikan
 */
public class ParallelCountBenchTest {

    private static final String ALICE = "src/test/resources/alice.txt";
    private static final String WAR_AND_PEACE = "src/test/resources/war_and_peace.txt";
    private static final int LENGTH = 12;

    @Test(expected = IllegalArgumentException.class)
    public void run_IAE() throws IOException {
        ParallelCountBench.run(ALICE, -1);
    }

    @Test(expected = IOException.class)
    public void run_IOE() throws IOException {
        ParallelCountBench.run("", LENGTH);
    }

    @Test
    public void run_aliceInput() throws IOException {
        ParallelCountBench.run(ALICE, LENGTH);
    }

    @Test
    public void run_warAndPeaceInput() throws IOException {
        ParallelCountBench.run(WAR_AND_PEACE, LENGTH);
    }
}
