/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch04.ex08;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JavaBean adapter of the {@link javax.swing.JPanel}.
 *
 * @author mikan
 */
public class JPanelAdapter extends JPanel {

    private static final long serialVersionUID = 1L;

    private final List<Component> children;

    public JPanelAdapter() {
        children = new ArrayList<>();
    }

    public List<Component> getChildren() {
        return children;
    }

    @Override
    public void doLayout() {
        if (children == null) {
            return;
        }
        removeAll();
        children.forEach(this::add);
        super.doLayout();
    }
}
