package de.haevn.jfx.tools.creation.pane;

import de.haevn.jfx.tools.creation.BaseCreator;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class GridPaneCreator extends BaseCreator<GridPane, GridPaneCreator> implements IPaneCreator<GridPane> {
    public GridPaneCreator() {
        super(new GridPane());
        super.setInstance(this);
    }

    public static GridPaneCreator start() {
        return new GridPaneCreator();
    }

    @Override
    public IPaneCreator<GridPane> withPadding(double padding) {
        return withPadding(padding, padding, padding, padding);
    }

    @Override
    public GridPaneCreator withPadding(double top, double right, double bottom, double left) {
        object.setPadding(new Insets(top, right, bottom, left));
        return this;
    }

    @Override
    public GridPaneCreator withSpacing(double spacing) {
        object.setHgap(spacing);
        object.setVgap(spacing);
        return this;
    }

    public GridPaneCreator addElement(final Node node, final int row, final int column) {
        object.add(node, column, row);
        return this;
    }


    public GridPaneCreator addElement(final Node node, final int row, final int column, final Alignment alignment) {
        object.add(node, column, row);
        GridPane.setValignment(node, alignment.verticalAlignment);
        GridPane.setHalignment(node, alignment.horizontalAlignment);

        return this;
    }

    public GridPaneCreator addElement(final Node node, final int row, final int column, final Growth growth) {
        object.add(node, column, row);
        GridPane.setVgrow(node, growth.verticalGrowth);
        GridPane.setHgrow(node, growth.horizontalGrowth);
        return this;
    }

    public GridPaneCreator addElement(final Node node, final int row, final int column, final Alignment alignment, final Growth growth) {
        object.add(node, column, row);
        GridPane.setValignment(node, alignment.verticalAlignment);
        GridPane.setHalignment(node, alignment.horizontalAlignment);
        GridPane.setVgrow(node, growth.verticalGrowth);
        GridPane.setHgrow(node, growth.horizontalGrowth);
        return this;
    }


    public enum Alignment {
        TOP_LEFT(VPos.TOP, HPos.LEFT),
        TOP_CENTER(VPos.TOP, HPos.CENTER),
        TOP_RIGHT(VPos.TOP, HPos.RIGHT),
        CENTER_LEFT(VPos.CENTER, HPos.LEFT),
        CENTER_CENTER(VPos.CENTER, HPos.CENTER),
        CENTER_RIGHT(VPos.CENTER, HPos.RIGHT),
        BOTTOM_LEFT(VPos.BOTTOM, HPos.LEFT),
        BOTTOM_CENTER(VPos.BOTTOM, HPos.CENTER),
        BOTTOM_RIGHT(VPos.BOTTOM, HPos.RIGHT);

        private final VPos verticalAlignment;
        private final HPos horizontalAlignment;

        Alignment(final VPos verticalAlignment, final HPos horizontalAlignment) {
            this.verticalAlignment = verticalAlignment;
            this.horizontalAlignment = horizontalAlignment;
        }

        public VPos getVerticalAlignment() {
            return verticalAlignment;
        }

        public HPos getHorizontalAlignment() {
            return horizontalAlignment;
        }
    }

    public enum Growth {
        LEFT(Priority.NEVER, Priority.ALWAYS),
        BOTTOM(Priority.ALWAYS, Priority.NEVER),
        BOOTH(Priority.ALWAYS, Priority.ALWAYS),
        NONE(Priority.NEVER, Priority.NEVER);

        private final Priority horizontalGrowth;
        private final Priority verticalGrowth;

        Growth(final Priority horizontalGrowth, final Priority verticalGrowth) {
            this.horizontalGrowth = horizontalGrowth;
            this.verticalGrowth = verticalGrowth;
        }

    }
}
