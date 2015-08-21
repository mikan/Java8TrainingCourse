/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch05.ex05;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author mikan
 */
public class LifeTime {

    private static final LocalDate DAY_OF_BIRTH = LocalDate.of(1988, 4, 12);
    private static final LocalTime EMPTY_TIME = LocalTime.of(0, 0);

    private LifeTime() {
        // static use only
    }

    public static int calcLifeDates() {
        return (int) Duration.between(LocalDateTime.of(DAY_OF_BIRTH, EMPTY_TIME), LocalDateTime.now()).toDays();
    }
}
