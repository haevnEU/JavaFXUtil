package de.haevn.jfx.html;

import javafx.scene.control.Label;

/**
 * javadoc is WIP
 * @version 1.0
 * @since 1.0
 * @author haevn
 */
public class H1 extends H {
    public H1() {
        this("");
    }

    public H1(String text) {
        getStyleClass().add("html-h1");
        setText(text);
        setStyle("-fx-font-size: 24;-fx-font-weight: bolder");
    }
}
