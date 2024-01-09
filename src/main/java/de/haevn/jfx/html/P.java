package de.haevn.jfx.html;

import javafx.scene.control.Label;

/**
 * javadoc is WIP
 *
 * @author haevn
 * @version 1.0
 * @since 1.0
 */
public class P extends Label {
    public P() {
        this("");
    }

    public P(String text) {

        getStyleClass().add("html-text-paragraph");
        setText(text);
        setStyle("-fx-font-size: 16;");
    }

    public void setFontSize(int size) {
        setStyle("-fx-font-size: " + size + ";-fx-font-weight: italic;");
    }
}
