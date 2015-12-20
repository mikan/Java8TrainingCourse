/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch05.ex04;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mikan
 */
public class CalCommand {

    private static final String BR = System.getProperty("line.separator");
    private final DayOfWeek beginDayOfWeek;

    /**
     * Displays a calendar like the UNIX cal command.
     *
     * @param args [[month] year]
     */
    public static void main(String[] args) {
        Objects.requireNonNull(args);
        final LocalDate now = LocalDate.now();
        switch (args.length) {
            case 0:
                System.out.println(new CalCommand(DayOfWeek.MONDAY).createCalendar(now));
                break;
            case 1:
                try {
                    int year = textToYear(args[0]);
                    LocalDate date = LocalDate.of(year, now.getMonth(), now.getDayOfMonth());
                    System.out.println(new CalCommand(DayOfWeek.MONDAY).createYearCalendar(date));
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                    printUsage();
                }
                break;
            case 2:
                try {
                    int month = textToMonth(args[0]);
                    int year = textToYear(args[1]);
                    LocalDate date = LocalDate.of(year, month, now.getDayOfMonth());
                    System.out.println(new CalCommand(DayOfWeek.MONDAY).createCalendar(date));
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                    printUsage();
                }
                break;
            default:
                System.out.println("Illegal number of args: " + args.length);
                printUsage();
                break;
        }
    }

    private static void printUsage() {
        System.out.println("Usage: java " + CalCommand.class.getName() + " [[month] year]");
    }

    private static int textToMonth(String text) {
        int month;
        try {
            month = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Not a number: " + text, e);
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Not a month: " + text);
        }
        return month;
    }

    private static int textToYear(String text) {
        int year;
        try {
            year = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Not a number: " + text, e);
        }
        if (year < Year.MIN_VALUE || year > Year.MAX_VALUE) {
            throw new IllegalArgumentException("Not a year: " + text);
        }
        return year;
    }

    private static DayOfWeek nextDayOfWeek(DayOfWeek dayOfWeek) {
        return dayOfWeek == DayOfWeek.SUNDAY ? DayOfWeek.MONDAY : DayOfWeek.of(dayOfWeek.getValue() + 1);
    }

    private static DayOfWeek previousDayOfWeek(DayOfWeek dayOfWeek) {
        return dayOfWeek == DayOfWeek.MONDAY ? DayOfWeek.SUNDAY : DayOfWeek.of(dayOfWeek.getValue() - 1);
    }

    public CalCommand() {
        beginDayOfWeek = DayOfWeek.MONDAY;
    }

    public CalCommand(DayOfWeek beginDayOfWeek) {
        this.beginDayOfWeek = beginDayOfWeek;
    }

    public String createCalendar(LocalDate date) {
        LocalDate beginDate = LocalDate.of(date.getYear(), date.getMonth(), 1);
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%7d月 %d%n", date.getMonthValue(), date.getYear()));
        builder.append(String.format("月 火 水 木 金 土 日%n"));
        LocalDate work = beginDate;
        DayOfWeek dayOfWeek = beginDayOfWeek;
        while (dayOfWeek.getValue() < beginDate.getDayOfWeek().getValue()) {
            builder.append("   ");
            dayOfWeek = nextDayOfWeek(dayOfWeek);
        }
        while (work.getMonth() == date.getMonth()) {
            builder.append(String.format("%2d ", work.getDayOfMonth()));
            if (dayOfWeek == previousDayOfWeek(beginDayOfWeek)) {
                builder.append("\b").append(BR);
            }
            dayOfWeek = nextDayOfWeek(dayOfWeek);
            work = work.plusDays(1);
        }
        return builder.append(BR).toString();
    }

    public String createYearCalendar(LocalDate date) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%33d%n%n", date.getYear()));
        String[] calenders = new String[Month.DECEMBER.getValue()];
        for (int i = Month.JANUARY.getValue(); i <= Month.DECEMBER.getValue(); i++) {
            calenders[i - 1] = createCalendar(LocalDate.of(date.getYear(), Month.of(i), 1));
        }
        for (int i = 0; i < calenders.length / 4; i++) {
            List<String> cal1 = Arrays.asList(calenders[i].replaceAll("\b", "").split(BR));
            List<String> cal2 = Arrays.asList(calenders[i + 1].replaceAll("\b", "").split(BR));
            List<String> cal3 = Arrays.asList(calenders[i + 2].replaceAll("\b", "").split(BR));
            for (int k = 0; k < max(cal1.size(), cal2.size(), cal3.size()); k++) {
                builder.append(String.format("%-21s  %-21s  %-21s%n",
                        getOrEmpty(cal1, k), getOrEmpty(cal2, k), getOrEmpty(cal3, k)));
            }
            builder.append(BR);
        }
        return builder.toString();
    }

    private int max(int num, int... nums) {
        int max = num;
        for (int n : nums) {
            max = Math.max(max, n);
        }
        return max;
    }

    private String getOrEmpty(List<String> list, int index) {
        return index >= list.size() ? "" : list.get(index);
    }
}