package de.haevn.jfx.html;

import javafx.scene.Node;
import javafx.scene.layout.VBox;

/**
 * javadoc is WIP
 * @version 1.0
 * @since 1.0
 * @author haevn
 */
public class VDIV extends VBox {

    public VDIV() {
    }

    public VDIV(Node... elements) {
        getStyleClass().add("html-div-vertical");
        setContent(elements);
    }

    public void setContent(Node... elements) {
        setId("haevn-widgets-div");
        getChildren().clear();
        getChildren().addAll(elements);
    }
}
