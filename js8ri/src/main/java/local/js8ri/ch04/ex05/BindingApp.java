/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch04.ex05;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Based on Horstmann's <code>BindingDemo3</code>.
 *
 * @author mikan
 */
public class BindingApp extends Application {

    private static final int DEFAULT_MIN = 0;
    private static final int DEFAULT_MAX = 100;
    private static final int DEFAULT_VALUE = 50;

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("BindingApp");
        Button smaller = new Button("Smaller");
        Button larger = new Button("Larger");
        Rectangle gauge = new Rectangle(DEFAULT_MIN, 5, DEFAULT_VALUE, 15);
        Rectangle outline = new Rectangle(DEFAULT_MIN, 5, DEFAULT_MAX, 15);
        outline.setFill(null);
        outline.setStroke(Color.BLACK);
        Pane pane = new Pane();
        pane.getChildren().addAll(gauge, outline);
        smaller.setOnAction(event -> gauge.setWidth(gauge.getWidth() - 10));
        larger.setOnAction(event -> gauge.setWidth(gauge.getWidth() + 10));
        TextField minField = new TextField();
        minField.setText(Integer.toString(DEFAULT_MIN));
        minField.setFocusTraversable(false);
        TextField maxField = new TextField();
        maxField.setText(Integer.toString(DEFAULT_MAX));
        maxField.setFocusTraversable(false);
        smaller.disableProperty().bind(Observer.observe(
                (t, u) -> t.doubleValue() <= string2safeValue(u, DEFAULT_MIN),
                gauge.widthProperty(), minField.textProperty()));
        larger.disableProperty().bind(Observer.observe(
                (t, u) -> t.doubleValue() >= string2safeValue(u, DEFAULT_MAX),
                gauge.widthProperty(), maxField.textProperty()));
        outline.widthProperty().bind(Observer.observe(
                t -> string2safeValue(t, DEFAULT_MAX), maxField.textProperty()));
        VBox box = new VBox(10);
        HBox h1 = new HBox(5, smaller, pane, larger);
        h1.setAlignment(Pos.CENTER);
        HBox h2 = new HBox(0, minField, maxField);
        h2.setAlignment(Pos.CENTER);
        box.getChildren().addAll(h1, h2);
        Scene scene = new Scene(box);
        stage.setScene(scene);
        stage.show();
    }

    private static double string2safeValue(String s, double defaultValue) {
        double value;
        try {
            value = Double.parseDouble(s);
        } catch (NumberFormatException e) {
            value = defaultValue;
        }
        return value < 0 ? 0 : value;
    }
}
