/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */
package local.js8ri.ch03.ex12;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import javax.annotation.Nonnull;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.UnaryOperator;

/**
 *
 * @author mikan
 */
public class LatentImage {

    private final Image in;
    private final List<UnaryOperator<Color>> pendingOperations;

    protected LatentImage(@Nonnull Image in) {
        Objects.requireNonNull(in);
        this.in = in;
        pendingOperations = new LinkedList<>();
    }

    @Nonnull
    public static LatentImage from(@Nonnull Image in) {
        return new LatentImage(in);
    }

    @Nonnull
    public LatentImage transform(@Nonnull UnaryOperator<Color> f) {
        Objects.requireNonNull(f);
        pendingOperations.add(f);
        return this;
    }

    @Nonnull
    public Image toImage() {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = in.getPixelReader().getColor(x, y);
                for (UnaryOperator<Color> f : pendingOperations) {
                    c = f.apply(c);
                }
                out.getPixelWriter().setColor(x, y, c);
            }
        }
        return out;
    }

    protected Image getImage() {
        return in;
    }
}
