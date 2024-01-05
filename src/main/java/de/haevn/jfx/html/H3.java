package de.haevn.jfx.html;

import javafx.scene.control.Label;

/**
 * javadoc is WIP
 * @version 1.0
 * @since 1.0
 * @author haevn
 */
public class H3 extends H {
    public H3() {
        this("");
    }

    public H3(String text) {
        getStyleClass().add("html-h3");
        setText(text);
        setStyle("-fx-font-size: 18;-fx-font-weight: bolder");
    }
}
