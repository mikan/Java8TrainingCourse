/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch04.ex03;

import local.js8ri.ch04.ex02.GreetingWithChartAndTable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author mikan
 */
public class GreetingWithChartAndTableTest {

    @Test
    public void testTextProperty_nonNull() {
        assertNotNull(new local.js8ri.ch04.ex02.GreetingWithChartAndTable().textProperty());
    }

    @Test
    public void testSetText_nonNPE() {
        local.js8ri.ch04.ex02.GreetingWithChartAndTable greeting = new local.js8ri.ch04.ex02.GreetingWithChartAndTable();
        String input = "foo";
        greeting.setText(input);
    }

    @Test
    public void testGetText_nonNPE() {
        local.js8ri.ch04.ex02.GreetingWithChartAndTable greeting = new local.js8ri.ch04.ex02.GreetingWithChartAndTable();
        greeting.setText("bar");
        String output = greeting.getText();
        assertNotNull(output);
    }

    @Test
    public void testGetText_propertyCase() {
        local.js8ri.ch04.ex02.GreetingWithChartAndTable greeting = new local.js8ri.ch04.ex02.GreetingWithChartAndTable();
        greeting.setText("foo");
        assertEquals("foo", greeting.textProperty().get());
        greeting.setText("bar");
        assertEquals("bar", greeting.getText());
    }

    @Test
    public void testAllMethods_nonNull() {
        local.js8ri.ch04.ex02.GreetingWithChartAndTable greeting = new GreetingWithChartAndTable();
        assertNotNull(greeting.animatedProperty());
        assertNotNull(greeting.legendProperty());
        assertNotNull(greeting.legendSideProperty());
        assertNotNull(greeting.legendVisibleProperty());
        assertNotNull(greeting.titleProperty());
        assertNotNull(greeting.titleSideProperty());
        assertNotNull(greeting.columnResizePolicyProperty());
        assertNotNull(greeting.comparatorProperty());
        assertNotNull(greeting.editableProperty());
        assertNotNull(greeting.editingCellProperty());
        assertNotNull(greeting.fixedCellSizeProperty());
        assertNotNull(greeting.focusModelProperty());
        assertNotNull(greeting.itemsProperty());
        assertNotNull(greeting.onScrollToColumnProperty());
        assertNotNull(greeting.onScrollToProperty());
        assertNotNull(greeting.onSortProperty());
        assertNotNull(greeting.placeholderProperty());
        assertNotNull(greeting.rowFactoryProperty());
        assertNotNull(greeting.selectionModelProperty());
        assertNotNull(greeting.sortPolicyProperty());
        assertNotNull(greeting.tableMenuButtonVisibleProperty());
    }
}
