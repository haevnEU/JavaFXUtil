package de.haevn.jfx.tools.creation.pane;

import de.haevn.jfx.tools.creation.BaseCreator;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;

public class TabPaneCreator extends BaseCreator<TabPane, TabPaneCreator> implements IPaneCreator<TabPane> {
    private TabPaneCreator() {
        super(new TabPane());
        super.setInstance(this);
    }

    public static TabPaneCreator start() {
        return new TabPaneCreator();
    }


    public TabPaneCreator addTab(final String title, final Pane content) {
        return addTab(new TabBuilder(title, content));
    }

    public final TabPaneCreator addTab(TabPaneCreator.TabBuilder tabBuilder) {
        return addTab(tabBuilder.build());
    }

    public TabPaneCreator addTab(final Tab tab) {
        object.getTabs().add(tab);
        return this;
    }

    @Override
    public TabPaneCreator withPadding(double padding) {
        return withPadding(padding, padding, padding, padding);
    }

    @Override
    public TabPaneCreator withPadding(double top, double right, double bottom, double left) {
        object.setPadding(new Insets(top, right, bottom, left));
        return this;
    }

    @Override
    public TabPaneCreator withSpacing(double spacing) {
        return this;
    }


    public static class TabBuilder {
        private final Tab tab = new Tab();

        public TabBuilder() {
            tab.setClosable(false);
        }

        public TabBuilder(final String title, final Node content) {
            tab.setContent(content);
            tab.setText(title);
            tab.setClosable(false);
        }

        public TabBuilder withContent(final Node content) {
            tab.setContent(content);
            return this;
        }

        public TabBuilder withTitle(final String title) {
            tab.setText(title);
            return this;
        }

        public TabBuilder withClosable(final boolean closable) {
            tab.setClosable(closable);
            return this;
        }

        public TabBuilder withDisable(final boolean disable) {
            tab.setDisable(disable);
            return this;
        }

        public Tab build() {
            return tab;
        }
    }
}
