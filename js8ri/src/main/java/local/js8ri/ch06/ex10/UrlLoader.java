/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch06.ex10;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mikan
 */
public class UrlLoader {

    public static void main(String[] args) {
        String url = "http://mikan.github.io/";
        CompletableFuture.supplyAsync(() -> getContent(url))
                .thenApply(UrlLoader::getLinks)
                .thenAccept(w -> w.forEach(System.out::println));
        ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
    }

    private static String getContent(String url) {
        StringBuilder builder = new StringBuilder();
        try (InputStream in = new URL(url).openStream();
             Scanner scanner = new Scanner(in, "UTF-8")) {
            String sep = System.getProperty("line.separator");
            while (scanner.hasNextLine()) {
                builder.append(scanner.nextLine()).append(sep);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return builder.toString();
    }

    private static List<String> getLinks(String content) {
        Pattern pattern = Pattern.compile("a\\s+href\\s*=\\s*\"(?<link>[^\"]+)\"");
        Matcher matcher = pattern.matcher(content);
        List<String> links = new ArrayList<>();
        while (matcher.find()) {
            links.add(matcher.group("link"));
        }
        return links;
    }
}
