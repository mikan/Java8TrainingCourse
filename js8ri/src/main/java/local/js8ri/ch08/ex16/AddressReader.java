/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch08.ex16;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mikan
 */
public class AddressReader {

    public static void main(String[] args) {
        List<String> data = Arrays.asList(
                "Yokohama, Kanagawa, 12345",
                "Kawasaki, Kanagawa, 123456789");
        Pattern pattern = Pattern.compile("(?<city>[\\p{L}]+),\\s*(?<state>[\\p{L}]+),\\s*(?<zip>[0-9]{5}|[0-9]{9})");
        data.stream().map(pattern::matcher).filter(Matcher::matches).forEach(m -> {
            String city = m.group("city");
            String state = m.group("state");
            String zip = m.group("zip");
            System.out.println("city=" + city + ", state=" + state + ", zip=" + zip);
        });
    }
}
