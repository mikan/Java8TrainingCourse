/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch01.ex05;

import local.js8ri.ch01.ex05.DigitalClockFrame.DigitalClockCanvas;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author mikan
 */
public class DigitalClockCanvasTest {

    private static final DigitalClockCanvas SUT = new DigitalClockCanvas();

    @Test
    public void testPaint_fontUpdateCheck() {
        int fontSize = 10000;
        Graphics g = createTestGraphics();
        g.setFont(new Font(Font.SERIF, Font.ITALIC, fontSize));
        SUT.update(g);
        assertNotEquals(fontSize, g.getFont().getSize());
    }

    @Test
    public void testUpdate_fontUpdateCheck() {
        int fontSize = 10000;
        Graphics g = createTestGraphics();
        g.setFont(new Font(Font.SERIF, Font.ITALIC, fontSize));
        SUT.update(g);
        assertNotEquals(fontSize, g.getFont().getSize());
    }

    private static Graphics createTestGraphics() {
        Graphics g = mock(TestGraphics.class);
        doCallRealMethod().when(g).setFont(any(Font.class));
        when(g.getFont()).thenCallRealMethod();
        return g;
    }

    private abstract static class TestGraphics extends Graphics {

        private Font font;

        @Override
        public void setFont(Font font) {
            this.font = font;
        }

        @Override
        public Font getFont() {
            return font;
        }
    }
}
