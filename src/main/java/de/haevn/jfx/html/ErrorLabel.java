package de.haevn.jfx.html;

import javafx.scene.control.Label;

/**
 * javadoc is WIP
 * @version 1.0
 * @since 1.0
 * @author haevn
 */
public class ErrorLabel extends Label {
    public ErrorLabel() {
        this("");
    }

    public ErrorLabel(String text) {
        this(text, "red");
    }

    public ErrorLabel(String text, String color) {
        getStyleClass().add("html-label-error");
        setText(text);
        setStyle("-fx-text-fill: " + color + ";-fx-font-weight: bolder");
    }
}
