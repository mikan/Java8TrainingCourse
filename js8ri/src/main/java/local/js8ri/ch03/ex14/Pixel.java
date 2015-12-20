/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch03.ex14;


import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

/**
 * Manages R/G/B and provides calculation methods.
 */
public class Pixel {
    private double r = 0;
    private double g = 0;
    private double b = 0;

    public static @Nonnull Pixel of(@Nonnull Color color) {
        Objects.requireNonNull(color);
        Pixel rgb = new Pixel();
        rgb.r = color.getRed();
        rgb.g = color.getGreen();
        rgb.b = color.getBlue();
        return rgb;
    }

    public static Pixel of(@Nonnull PixelReader reader, int x, int y) {
        Pixel pixel = ofNullable(reader, x, y);
        if (pixel == null) {
            throw new IllegalArgumentException("out of image: (" + x + ", " + y + ")");
        }
        return pixel;
    }

    public static @Nullable Pixel ofNullable(@Nonnull PixelReader reader, int x, int y) {
        Objects.requireNonNull(reader);
        try {
            return Pixel.of(reader.getColor(x, y));
        } catch (RuntimeException e) { // e.g. ArrayIndexOutOfBoundsException
            return null;
        }
    }

    public @Nonnull Pixel add(@Nonnull Pixel value) {
        Objects.requireNonNull(value);
        r += value.r;
        g += value.g;
        b += value.b;
        return this;
    }

    public @Nonnull Pixel div(int value) {
        if (value == 0) {
            throw new IllegalArgumentException("value is zero.");
        }
        r /= value;
        g /= value;
        b /= value;
        return this;
    }

    public @Nonnull Pixel edge(int count, @Nonnull Pixel value) {
        Objects.requireNonNull(value);
        r = r * count - value.r;
        g = g * count - value.g;
        b = b * count - value.b;
        return this;
    }

    @Nonnull
    public Color toColor() {
        return Color.color(safeValue(r), safeValue(g), safeValue(b));
    }

    private double safeValue(double source) {
        return source < 0 ? 0 : source > 1 ? 1 : source;
    }
}