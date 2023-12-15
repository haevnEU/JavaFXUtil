package de.haevn.jfx.html;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * javadoc is WIP
 * @version 1.0
 * @since 1.0
 * @author haevn
 */
public class DIV extends Pane {

    public DIV() {
    }

    public DIV(Node... elements) {
        setContent(elements);
    }

    public void setContent(Node... elements) {
        getStyleClass().add("html-div");
        getChildren().clear();
        getChildren().addAll(elements);
    }
}
