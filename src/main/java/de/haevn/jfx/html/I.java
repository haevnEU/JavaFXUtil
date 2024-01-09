package de.haevn.jfx.html;

import javafx.scene.control.Label;

/**
 * javadoc is WIP
 *
 * @author haevn
 * @version 1.0
 * @since 1.0
 */
public class I extends Label {
    public I() {
        this("");
    }

    public I(String text) {
        getStyleClass().add("html-text-italic");
        setText(text);
        setStyle("-fx-font-size: 16;-fx-font-weight: italic;");
    }

    public void setFontSize(int size) {
        setStyle("-fx-font-size: " + size + ";-fx-font-weight: italic;");
    }
}
