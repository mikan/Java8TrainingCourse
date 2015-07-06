/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch04.ex05;

import javafx.beans.value.ObservableValue;
import javafx.scene.shape.Rectangle;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author mikan
 */
public class ObserverTest {

    @Test
    public void testObserve_dualNormalInput() {
        Rectangle gauge = new Rectangle();
        gauge.setWidth(50);
        ObservableValue<Boolean> obsvalue = Observer.observe(t -> t.doubleValue() >= 100, gauge.widthProperty());
        assertNotNull(obsvalue);
        Boolean value1 = obsvalue.getValue();
        assertFalse(value1);
        gauge.setWidth(100);
        Boolean value2 = obsvalue.getValue();
        assertTrue(value2);
    }
}
