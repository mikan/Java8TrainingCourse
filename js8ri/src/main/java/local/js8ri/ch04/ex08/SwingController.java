/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch04.ex08;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author mikan
 */
public class SwingController implements Initializable {

    private static final String FXML = "swing.fxml";

    @FXML
    JFrameAdapter jframe;

    @FXML
    JMenuItem exitItem;

    @FXML
    JMenuItem aboutItem;

    public static void main(String[] args) throws IOException {
        new SwingController().load();
    }

    public void load() throws IOException {
        URL nb = getClass().getResource(FXML); // for NetBeans & Eclipse
        URL ij = getClass().getClassLoader().getResource(FXML); // for IntelliJ
        FXMLLoader.load(nb == null ? ij : nb);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("JFrame built: " + jframe.getTitle());
        exitItem.addActionListener(e -> System.exit(0));
        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(jframe, jframe.getTitle()));
    }
}
