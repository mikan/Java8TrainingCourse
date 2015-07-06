/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch04.ex02;

import javafx.beans.property.*;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.util.Comparator;

/**
 * CAUTION: This class is not thread-safe.
 *
 * @author mikan
 */
public class GreetingWithChartAndTable<S> {

    // From Greetings
    private StringProperty text;

    // From javafx.scene.chart.Chart
    private BooleanProperty animated;
    private ObjectProperty<Node> legend;
    private ObjectProperty<Node> legendSide;
    private BooleanProperty legendVisible;
    private StringProperty title;
    private ObjectProperty<Side> titleSide;

    // From javafx.scene.control.TableView
    private ObjectProperty<Callback<TableView.ResizeFeatures<S>, Boolean>> columnResizePolicy;
    private ReadOnlyObjectProperty<Comparator<S>> comparator;
    private BooleanProperty editable;
    private ReadOnlyObjectProperty<TablePosition<S, ?>> editingCell;
    private DoubleProperty fixedCellSize;
    private ObjectProperty<TableView.TableViewFocusModel<S>> focusModel;
    private ObjectProperty<ObservableList<S>> items;
    private ObjectProperty<EventHandler<ScrollToEvent<TableColumn<S, ?>>>> onScrollToColumn;
    private ObjectProperty<EventHandler<ScrollToEvent<Integer>>> onScrollTo;
    private ObjectProperty<EventHandler<SortEvent<TableView<S>>>> onSort;
    private ObjectProperty<Node> placeholder;
    private ObjectProperty<Callback<TableView<S>, TableRow<S>>> rowFactory;
    private ObjectProperty<TableView.TableViewSelectionModel<S>> selectionModel;
    private ObjectProperty<Callback<TableView<S>, Boolean>> sortPolicy;
    private BooleanProperty tableMenuButtonVisible;

    public final StringProperty textProperty() {
        return text == null ? new SimpleStringProperty("") : text;
    }

    public final void setText(String newValue) {
        textProperty().set(newValue);
    }

    public final String getText() {
        return textProperty().get();
    }

    public final BooleanProperty animatedProperty() {
        return animated == null ? new SimpleBooleanProperty() : animated;
    }

    public final ObjectProperty<Node> legendProperty() {
        return legend == null ? new SimpleObjectProperty<>() : legend;
    }

    public final ObjectProperty<Node> legendSideProperty() {
        return legendSide == null ? new SimpleObjectProperty<>() : legendSide;
    }

    public final BooleanProperty legendVisibleProperty() {
        return legendVisible == null ? new SimpleBooleanProperty() : legendVisible;
    }

    public final StringProperty titleProperty() {
        return title == null ? new SimpleStringProperty() : title;
    }

    public final ObjectProperty<Side> titleSideProperty() {
        return titleSide == null ? new SimpleObjectProperty<>() : titleSide;
    }

    public final ObjectProperty<Callback<TableView.ResizeFeatures<S>, Boolean>> columnResizePolicyProperty() {
        return columnResizePolicy == null ? new SimpleObjectProperty<>() : columnResizePolicy;
    }

    public final ReadOnlyObjectProperty<Comparator<S>> comparatorProperty() {
        return comparator == null ? new SimpleObjectProperty<>() : comparator;
    }

    public final BooleanProperty editableProperty() {
        return editable == null ? new SimpleBooleanProperty() : editable;
    }

    public final ReadOnlyObjectProperty<TablePosition<S, ?>> editingCellProperty() {
        return editingCell == null ? new SimpleObjectProperty<>() : editingCell;
    }

    public final DoubleProperty fixedCellSizeProperty() {
        return fixedCellSize == null ? new SimpleDoubleProperty() : fixedCellSize;
    }

    public final ObjectProperty<TableView.TableViewFocusModel<S>> focusModelProperty() {
        return focusModel == null ? new SimpleObjectProperty<>() : focusModel;
    }

    public final ObjectProperty<ObservableList<S>> itemsProperty() {
        return items == null ? new SimpleObjectProperty<>() : items;
    }

    public final ObjectProperty<EventHandler<ScrollToEvent<TableColumn<S, ?>>>> onScrollToColumnProperty() {
        return onScrollToColumn == null ? new SimpleObjectProperty<>() : onScrollToColumn;
    }

    public final ObjectProperty<EventHandler<ScrollToEvent<Integer>>> onScrollToProperty() {
        return onScrollTo == null ? new SimpleObjectProperty<>() : onScrollTo;
    }

    public final ObjectProperty<EventHandler<SortEvent<TableView<S>>>> onSortProperty() {
        return onSort == null ? new SimpleObjectProperty<>() : onSort;
    }

    public final ObjectProperty<Node> placeholderProperty() {
        return placeholder == null ? new SimpleObjectProperty<>() : placeholder;
    }

    public final ObjectProperty<Callback<TableView<S>, TableRow<S>>> rowFactoryProperty() {
        return rowFactory == null ? new SimpleObjectProperty<>() : rowFactory;
    }

    public final ObjectProperty<TableView.TableViewSelectionModel<S>> selectionModelProperty() {
        return selectionModel == null ? new SimpleObjectProperty<>() : selectionModel;
    }

    public final ObjectProperty<Callback<TableView<S>, Boolean>> sortPolicyProperty() {
        return sortPolicy == null ? new SimpleObjectProperty<>() : sortPolicy;
    }

    public final BooleanProperty tableMenuButtonVisibleProperty() {
        return tableMenuButtonVisible == null ? new SimpleBooleanProperty() : tableMenuButtonVisible;
    }
}
