/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch05.ex10;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.Objects;

/**
 *
 * @author mikan
 */
public class ArrivalTime {

    private ArrivalTime() {
        // static use only
    }

    public static LocalDateTime arrivalTime(
            LocalDateTime departureTime,
            ZoneId departureZone,
            Duration flightTime,
            ZoneId arrivalZone) {
        Objects.requireNonNull(departureTime);
        Objects.requireNonNull(departureZone);
        Objects.requireNonNull(flightTime);
        Objects.requireNonNull(arrivalZone);
        return ZonedDateTime.of(departureTime, departureZone).plus(flightTime)
                .withZoneSameInstant(arrivalZone).toLocalDateTime();
    }

    /**
     * Create a {@link Duration} with hours and minutes.
     *
     * @param h hours
     * @param m minites
     * @return duration
     * @throws DateTimeParseException if the text cannot be parsed to a duration
     */
    public static Duration createHMDuration(int h, int m) {
        // return Duration.parse("PT" + h + "H" + m + "M");
        return Duration.ofMinutes(h * 60 + m);
    }
}
