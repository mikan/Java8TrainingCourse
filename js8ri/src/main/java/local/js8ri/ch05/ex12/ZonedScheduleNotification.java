/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch05.ex12;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.*;
import java.util.Map.Entry;

/**
 * Created by mikan on 2015/09/15.
 *
 * @author mikan
 */
public class ZonedScheduleNotification {

    private static final String FORMAT_PATTERN = "yyyyMMdd HHmmss";
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern(FORMAT_PATTERN);
    private final List<Entry<String, Entry<ZonedDateTime, ZonedDateTime>>> schedules;
    private final Timer timer;
    private ZoneId currentZoneId;

    public static void main(String[] args) {
        ZonedScheduleNotification notification = new ZonedScheduleNotification();
        Scanner scanner = new Scanner(System.in);
        EXIT:
        while (true) {
            System.out.print("put/list/exit > ");
            String input = scanner.nextLine();
            switch (input) {
                case "quit":
                case "exit":
                    break EXIT;
                case "put":
                    System.out.print("input subject > ");
                    String subject = scanner.nextLine();
                    System.out.print("input begin [" + FORMAT_PATTERN + "] > ");
                    LocalDateTime begin = safeParse(scanner.nextLine());
                    if (begin == null) {
                        break;
                    }
                    System.out.print("input end [" + FORMAT_PATTERN + "] > ");
                    LocalDateTime end = safeParse(scanner.nextLine());
                    if (end == null) {
                        break;
                    }
                    if (notification.putSchedule(subject, begin, end)) {
                        System.out.println("Scheduled.");
                    } else {
                        System.err.println("Failed.");
                    }
                    break;
                case "list":
                    notification.getSchedules().forEach(e -> System.out.println(
                            e.getKey() + " (" + e.getValue().getKey() + " - " + e.getValue().getValue() + ")"));
                    break;
                case "":
                    break;
                default:
                    System.out.println("Unknown input: " + input);
                    break;
            }
        }
        System.exit(0);
    }

    @Nullable
    private static LocalDateTime safeParse(@Nullable String input) {
        try {
            return LocalDateTime.parse(input, FORMAT);
        } catch (DateTimeParseException e) {
            System.err.println("ERROR: " + e.getLocalizedMessage());
            return null;
        }
    }

    public ZonedScheduleNotification() {
        this(ZoneId.systemDefault());
    }

    public ZonedScheduleNotification(ZoneId zoneId) {
        currentZoneId = zoneId;
        schedules = new ArrayList<>();
        timer = new Timer();
    }

    public void changeTimeZone(@NonNull ZoneId zoneId) {
        Objects.requireNonNull(zoneId);
        currentZoneId = zoneId;
        timer.cancel();
    }

    public boolean putSchedule(@NonNull String subject, @NonNull LocalDateTime begin, @NonNull LocalDateTime end) {
        return putSchedule(subject, ZonedDateTime.of(begin, currentZoneId), ZonedDateTime.of(end, currentZoneId));
    }

    public boolean putSchedule(@NonNull String subject, @NonNull ZonedDateTime begin, @NonNull ZonedDateTime end) {
        Objects.requireNonNull(begin);
        Objects.requireNonNull(end);
        schedules.add(new SimpleImmutableEntry<>(subject, new SimpleImmutableEntry<>(begin, end)));
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("***** NOTIFICATION: " + subject);
            }
        }, Date.from(begin.withZoneSameInstant(currentZoneId).toInstant()));
        return true;
    }

    @NonNull
    public List<Entry<String, Entry<ZonedDateTime, ZonedDateTime>>> getSchedules() {
        return Collections.unmodifiableList(schedules);
    }
}
