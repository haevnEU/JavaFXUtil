package de.haevn.jfx.html;

import javafx.scene.Node;
import javafx.scene.layout.HBox;

/**
 * javadoc is WIP
 *
 * @author haevn
 * @version 1.0
 * @since 1.0
 */
public class HDIV extends HBox {

    public HDIV() {
    }

    public HDIV(Node... elements) {
        setContent(elements);
    }

    public void setContent(Node... elements) {
        getStyleClass().add("html-div-horizontal");
        getChildren().clear();
        getChildren().addAll(elements);
    }
}
