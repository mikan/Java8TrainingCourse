/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch08.ex11;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

/**
 * Load RNavi.
 *
 * @author mikan
 */
public class RnaviLoader {

    private static final String TARGET = "http://www.rnavi.com/rnavi/rstyle/shop/";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("rnavi user: ");
        String user = scanner.nextLine();
        System.out.print("rnavi pass: ");
        String password = scanner.nextLine();
        URLConnection connection = new URL(TARGET).openConnection();
        Base64.Encoder encoder = Base64.getEncoder();
        String original = user + ":" + password;
        String encoded = encoder.encodeToString(original.getBytes(StandardCharsets.UTF_8));
        connection.setRequestProperty("Authorization", "Basic " + encoded);
        connection.connect();
        try (Scanner input = new Scanner(connection.getInputStream(), "Shift_JIS")) {
            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }
        }
    }
}
