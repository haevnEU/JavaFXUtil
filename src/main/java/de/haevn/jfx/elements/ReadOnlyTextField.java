package de.haevn.jfx.elements;


import javafx.scene.control.TextField;

/**
 * javadoc is WIP
 * @version 1.0
 * @since 1.0
 * @author haevn
 */

public class ReadOnlyTextField extends TextField {
    public ReadOnlyTextField() {
        this("");
    }

    public ReadOnlyTextField(String text) {
        super(text);
        setEditable(false);
    }
}
