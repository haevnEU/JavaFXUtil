package de.haevn.jfx.tools.creation.pane;

import de.haevn.jfx.tools.creation.BaseCreator;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.TitledPane;

public class TitledPaneCreator extends BaseCreator<TitledPane, TitledPaneCreator> implements IPaneCreator<TitledPane> {

    public TitledPaneCreator() {
        super(new TitledPane());
        super.setInstance(this);
        withStyleClass("fx-haevn-titledpane");
    }


    public static TitledPaneCreator start(final String title) {

        return new TitledPaneCreator().withTitle(title);
    }

    public TitledPaneCreator withTitle(final String title) {
        object.setText(title);
        return this;
    }

    public TitledPaneCreator withContent(final Node content) {
        object.setContent(content);
        return this;
    }

    public TitledPaneCreator withExpanded(final boolean expanded) {
        object.setExpanded(expanded);
        return this;
    }

    @Override
    public TitledPaneCreator withPadding(double padding) {
        return withPadding(padding, padding, padding, padding);
    }

    @Override
    public TitledPaneCreator withPadding(double top, double right, double bottom, double left) {
        object.setPadding(new Insets(top, right, bottom, left));
        return this;
    }

    @Override
    public TitledPaneCreator withSpacing(double spacing) {

        return this;
    }
}
