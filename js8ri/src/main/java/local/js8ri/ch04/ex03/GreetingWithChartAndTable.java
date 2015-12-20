/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

package local.js8ri.ch04.ex03;

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
    private volatile StringProperty text = null;

    // From javafx.scene.chart.Chart
    private volatile BooleanProperty animated = null;
    private volatile ObjectProperty<Node> legend = null;
    private volatile ObjectProperty<Node> legendSide = null;
    private volatile BooleanProperty legendVisible = null;
    private volatile StringProperty title = null;
    private volatile ObjectProperty<Side> titleSide = null;

    // From javafx.scene.control.TableView
    private volatile ObjectProperty<Callback<TableView.ResizeFeatures<S>, Boolean>> columnResizePolicy = null;
    private volatile ReadOnlyObjectProperty<Comparator<S>> comparator = null;
    private volatile BooleanProperty editable = null;
    private volatile ReadOnlyObjectProperty<TablePosition<S, ?>> editingCell = null;
    private volatile DoubleProperty fixedCellSize = null;
    private volatile ObjectProperty<TableView.TableViewFocusModel<S>> focusModel = null;
    private volatile ObjectProperty<ObservableList<S>> items = null;
    private volatile ObjectProperty<EventHandler<ScrollToEvent<TableColumn<S, ?>>>> onScrollToColumn = null;
    private volatile ObjectProperty<EventHandler<ScrollToEvent<Integer>>> onScrollTo = null;
    private volatile ObjectProperty<EventHandler<SortEvent<TableView<S>>>> onSort = null;
    private volatile ObjectProperty<Node> placeholder = null;
    private volatile ObjectProperty<Callback<TableView<S>, TableRow<S>>> rowFactory = null;
    private volatile ObjectProperty<TableView.TableViewSelectionModel<S>> selectionModel = null;
    private volatile ObjectProperty<Callback<TableView<S>, Boolean>> sortPolicy = null;
    private volatile BooleanProperty tableMenuButtonVisible = null;

    public final StringProperty textProperty() {
        if (text == null) {
            synchronized (this) {
                if (text == null) {
                    text = new SimpleStringProperty("");
                }
            }
        }
        return text;
    }

    public final void setText(String newValue) {
        textProperty().set(newValue);
    }

    public final String getText() {
        return textProperty().get();
    }

    public final BooleanProperty animatedProperty() {
        if (animated == null) {
            synchronized (this) {
                if (animated == null) {
                    animated = new SimpleBooleanProperty();
                }
            }
        }
        return animated;
    }

    public final ObjectProperty<Node> legendProperty() {
        if (legend == null) {
            synchronized (this) {
                if (legend == null) {
                    legend = new SimpleObjectProperty<>();
                }
            }
        }
        return legend;
    }

    public final ObjectProperty<Node> legendSideProperty() {
        if (legendSide == null) {
            synchronized (this) {
                if (legendSide == null) {
                    legendSide = new SimpleObjectProperty<>();
                }
            }
        }
        return legendSide;
    }

    public final BooleanProperty legendVisibleProperty() {
        if (legendVisible == null) {
            synchronized (this) {
                if (legendVisible == null) {
                    legendVisible = new SimpleBooleanProperty();
                }
            }
        }
        return legendVisible;
    }

    public final StringProperty titleProperty() {
        if (title == null) {
            synchronized (this) {
                if (title == null) {
                    title = new SimpleStringProperty();
                }
            }
        }
        return title;
    }

    public final ObjectProperty<Side> titleSideProperty() {
        if (titleSide == null) {
            synchronized (this) {
                if (titleSide == null) {
                    titleSide = new SimpleObjectProperty<>();
                }
            }
        }
        return titleSide;
    }

    public final ObjectProperty<Callback<TableView.ResizeFeatures<S>, Boolean>> columnResizePolicyProperty() {
        if (columnResizePolicy == null) {
            synchronized (this) {
                if (columnResizePolicy == null) {
                    columnResizePolicy = new SimpleObjectProperty<>();
                }
            }
        }
        return columnResizePolicy;
    }

    public final ReadOnlyObjectProperty<Comparator<S>> comparatorProperty() {
        if (comparator == null) {
            synchronized (this) {
                if (comparator == null) {
                    comparator = new SimpleObjectProperty<>();
                }
            }
        }
        return comparator;
    }

    public final BooleanProperty editableProperty() {
        if (editable == null) {
            synchronized (this) {
                if (editable == null) {
                    editable = new SimpleBooleanProperty();
                }
            }
        }
        return editable;
    }

    public final ReadOnlyObjectProperty<TablePosition<S, ?>> editingCellProperty() {
        if (editingCell == null) {
            synchronized (this) {
                if (editingCell == null) {
                    editingCell = new SimpleObjectProperty<>();
                }
            }
        }
        return editingCell;
    }

    public final DoubleProperty fixedCellSizeProperty() {
        if (fixedCellSize == null) {
            synchronized (this) {
                if (fixedCellSize == null) {
                    fixedCellSize = new SimpleDoubleProperty();
                }
            }
        }
        return fixedCellSize;
    }

    public final ObjectProperty<TableView.TableViewFocusModel<S>> focusModelProperty() {
        if (focusModel == null) {
            synchronized (this) {
                if (focusModel == null) {
                    focusModel = new SimpleObjectProperty<>();
                }
            }
        }
        return focusModel;
    }

    public final ObjectProperty<ObservableList<S>> itemsProperty() {
        if (items == null) {
            synchronized (this) {
                if (items == null) {
                    items = new SimpleObjectProperty<>();
                }
            }
        }
        return items;
    }

    public final ObjectProperty<EventHandler<ScrollToEvent<TableColumn<S, ?>>>> onScrollToColumnProperty() {
        if (onScrollToColumn == null) {
            synchronized (this) {
                if (onScrollToColumn == null) {
                    onScrollToColumn = new SimpleObjectProperty<>();
                }
            }
        }
        return onScrollToColumn;
    }

    public final ObjectProperty<EventHandler<ScrollToEvent<Integer>>> onScrollToProperty() {
        if (onScrollTo == null) {
            synchronized (this) {
                if (onScrollTo == null) {
                    onScrollTo = new SimpleObjectProperty<>();
                }
            }
        }
        return onScrollTo;
    }

    public final ObjectProperty<EventHandler<SortEvent<TableView<S>>>> onSortProperty() {
        if (onSort == null) {
            synchronized (this) {
                if (onSort == null) {
                    onSort = new SimpleObjectProperty<>();
                }
            }
        }
        return onSort;
    }

    public final ObjectProperty<Node> placeholderProperty() {
        if (placeholder == null) {
            synchronized (this) {
                if (placeholder == null) {
                    placeholder = new SimpleObjectProperty<>();
                }
            }
        }
        return placeholder;
    }

    public final ObjectProperty<Callback<TableView<S>, TableRow<S>>> rowFactoryProperty() {
        if (rowFactory == null) {
            synchronized (this) {
                if (rowFactory == null) {
                    rowFactory = new SimpleObjectProperty<>();
                }
            }
        }
        return rowFactory;
    }

    public final ObjectProperty<TableView.TableViewSelectionModel<S>> selectionModelProperty() {
        if (selectionModel == null) {
            synchronized (this) {
                if (selectionModel == null) {
                    selectionModel = new SimpleObjectProperty<>();
                }
            }
        }
        return selectionModel;
    }

    public final ObjectProperty<Callback<TableView<S>, Boolean>> sortPolicyProperty() {
        if (sortPolicy == null) {
            synchronized (this) {
                if (sortPolicy == null) {
                    sortPolicy = new SimpleObjectProperty<>();
                }
            }
        }
        return sortPolicy;
    }

    public final BooleanProperty tableMenuButtonVisibleProperty() {
        if (tableMenuButtonVisible == null) {
            synchronized (this) {
                if (tableMenuButtonVisible == null) {
                    tableMenuButtonVisible = new SimpleBooleanProperty();
                }
            }
        }
        return tableMenuButtonVisible;
    }
}
