package de.haevn.jfx.html;

import javafx.scene.control.Label;

/**
 * javadoc is WIP
 *
 * @author haevn
 * @version 1.0
 * @since 1.0
 */
public class ErrorLabel extends Label {
    public ErrorLabel() {
        this("");
    }
    public ErrorLabel(final String text) {
        this(text, 12);
    }

    public ErrorLabel(String text, final int size) {
        setText(text);
        setStyle("-fx-text-fill: red; -fx-font-size: " + size + "; -fx-font-weight: bolder");
    }
}
