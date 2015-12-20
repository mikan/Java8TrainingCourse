/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch05.ex09;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.time.Instant;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author mikan
 */
public class TimeZoneOffsets {

    private TimeZoneOffsets() {
        // static use only
    }

    public static @NonNull List<String> getTimeZones(@NonNull Instant instant, int limit) {
        Objects.requireNonNull(instant);
        if (limit < 1) {
            throw new IllegalArgumentException("limit requires 1 or larger: " + limit);
        }
        final int seconds = limit * 60 * 60;
        return ZoneId.getAvailableZoneIds().stream()
                .map(z -> instant.atZone(ZoneId.of(z)))
                .filter(z -> z.getOffset().getTotalSeconds() < seconds && z.getOffset().getTotalSeconds() > -seconds)
                .map(z -> z.getOffset() + " (" + z.getZone().toString() + ")")
                .collect(Collectors.toList());
    }
}
