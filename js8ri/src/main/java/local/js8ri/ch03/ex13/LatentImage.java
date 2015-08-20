/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex13;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 *
 * @author mikan
 */
public class LatentImage {

    private final Image in;
    private final List<TransformerApp.ColorTransformer> pendingOperations;

    private LatentImage(Image in) {
        this.in = in;
        pendingOperations = new LinkedList<>();
    }

    public static LatentImage from(Image in) {
        return new LatentImage(in);
    }

    public LatentImage transform(UnaryOperator<Color> f) {
        pendingOperations.add(TransformerApp.createColorTransformer(f));
        return this;
    }

    public LatentImage transform(TransformerApp.ColorTransformer f) {
        pendingOperations.add(f);
        return this;
    }

    public Image toImage() {
        Image in = getImage();
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = in.getPixelReader().getColor(x, y);
                for (TransformerApp.ColorTransformer f : pendingOperations) {
                    c = f.apply(x, y, this);
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
