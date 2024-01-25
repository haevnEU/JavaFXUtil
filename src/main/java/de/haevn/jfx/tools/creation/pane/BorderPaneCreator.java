package de.haevn.jfx.tools.creation.pane;

import de.haevn.jfx.tools.creation.BaseCreator;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class BorderPaneCreator extends BaseCreator<BorderPane, BorderPaneCreator> implements IPaneCreator<BorderPane> {
    public BorderPaneCreator() {
        super(new BorderPane());
        super.setInstance(this);
    }

    public static BorderPaneCreator start() {
        return new BorderPaneCreator();
    }

    @Override
    public BorderPaneCreator withPadding(double padding) {
        return withPadding(padding, padding, padding, padding);
    }

    @Override
    public BorderPaneCreator withPadding(double top, double right, double bottom, double left) {
        object.setPadding(new Insets(top, right, bottom, left));
        return this;
    }

    @Override
    public BorderPaneCreator withSpacing(double spacing) {
        return this;
    }

    public BorderPaneCreator withTop(final Node node) {
        object.setTop(node);
        return this;
    }

    public BorderPaneCreator withCenter(final Node node) {
        object.setCenter(node);
        return this;
    }

    public BorderPaneCreator withBottom(final Node node) {
        object.setBottom(node);
        return this;
    }

    public BorderPaneCreator withLeft(final Node node) {
        object.setLeft(node);
        return this;
    }

    public BorderPaneCreator withRight(final Node node) {
        object.setRight(node);
        return this;
    }
}
