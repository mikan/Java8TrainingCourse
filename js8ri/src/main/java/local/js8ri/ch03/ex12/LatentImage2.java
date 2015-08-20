/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch03.ex12;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import local.js8ri.ch03.ex12.TransformerApp.ColorTransformer;

import javax.annotation.Nonnull;
import java.util.LinkedList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 *
 * @author mikan
 */
public class LatentImage2 extends LatentImage {

    private final List<ColorTransformer> pendingOperations;
    
    private LatentImage2(Image in) {
        super(in);
        pendingOperations = new LinkedList<>();
    }

    @Nonnull
    public static LatentImage2 from(@Nonnull Image in) {
        return new LatentImage2(in);
    }

    @Nonnull
    @Override
    public LatentImage2 transform(@Nonnull UnaryOperator<Color> f) {
        pendingOperations.add(TransformerApp.createColorTransformer(f));
        return this;
    }

    @Nonnull
    public LatentImage2 transform(@Nonnull ColorTransformer f) {
        pendingOperations.add(f);
        return this;
    }

    @Nonnull
    @Override
    public Image toImage() {
        Image in = getImage();
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = in.getPixelReader().getColor(x, y);
                for (ColorTransformer f : pendingOperations) {
                    c = f.apply(x, y, c);
                }
                out.getPixelWriter().setColor(x, y, c);
            }
        }
        return out;
    }
}
