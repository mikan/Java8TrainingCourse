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
 * JavaBean adapter of the {@link javax.swing.JFrame}.
 *
 * @author mikan
 */
public final class JFrameAdapter extends JFrame {

    private static final long serialVersionUID = 1L;
    private final List<Component> children;

    public JFrameAdapter() {
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
        Container container = getContentPane();
        container.removeAll();
        children.forEach(container::add);
        super.doLayout();
    }
}
