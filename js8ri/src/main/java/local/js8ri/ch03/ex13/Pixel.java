/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch03.ex13;


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

    @Nonnull
    public static Pixel of(@Nonnull Color color) {
        Objects.requireNonNull(color);
        Pixel rgb = new Pixel();
        rgb.r = color.getRed();
        rgb.g = color.getGreen();
        rgb.b = color.getBlue();
        return rgb;
    }

    public static Pixel of(@Nonnull LatentImage image, int x, int y) {
        Pixel pixel = ofNullable(image, x, y);
        if (pixel == null) {
            throw new IllegalArgumentException("out of image: (" + x + ", " + y + ")");
        }
        return pixel;
    }

    @Nullable
    public static Pixel ofNullable(@Nonnull LatentImage image, int x, int y) {
        Objects.requireNonNull(image);
        if (x < 0 || image.getImage().getWidth() <= x) {
            return null;
        }
        if (y < 0 || image.getImage().getHeight() <= y) {
            return null;
        }
        return Pixel.of(image.getImage().getPixelReader().getColor(x, y));
    }

    @Nonnull
    public Pixel add(@Nonnull Pixel value) {
        Objects.requireNonNull(value);
        r += value.r;
        g += value.g;
        b += value.b;
        return this;
    }

    @Nonnull
    public Pixel div(int value) {
        if (value == 0) {
            throw new IllegalArgumentException("value is zero.");
        }
        r /= value;
        g /= value;
        b /= value;
        return this;
    }

    @Nonnull
    public Pixel edge(int count, @Nonnull Pixel value) {
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