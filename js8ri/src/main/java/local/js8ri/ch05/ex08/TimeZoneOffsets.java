/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch05.ex08;

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

    public static @NonNull List<String> getTimeZoneOffsets(@NonNull Instant instant) {
        Objects.requireNonNull(instant);
        return ZoneId.getAvailableZoneIds().stream()
                .map(z -> instant.atZone(ZoneId.of(z)))
                .map(z -> z.getOffset() + " (" + z.getZone().toString() + ")")
                .collect(Collectors.toList());
    }
}
