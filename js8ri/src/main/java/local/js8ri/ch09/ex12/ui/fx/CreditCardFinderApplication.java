/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */
package local.js8ri.ch09.ex12.ui.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author mikan
 */
public class CreditCardFinderApplication extends Application {

    private static final String FXML = "CreditCardFinderView.fxml";
    private static final String APPLICATION_TITLE = "Credit Card Finder";


    public static void main(String[] args) {
        Application.launch(CreditCardFinderApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FXML));
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle(APPLICATION_TITLE);
        primaryStage.show();
    }
}
