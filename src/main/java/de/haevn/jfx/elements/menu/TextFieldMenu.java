package de.haevn.jfx.elements.menu;

import de.haevn.jfx.tools.creation.elements.TextInputCreator;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;

public class TextFieldMenu extends AbstractCustomMenuItem<TextField> {
    public TextFieldMenu(String prompt, Runnable action) {
        super(TextInputCreator.startTextField("").withPromptText("").buildTextField(), action);
    }

    public TextFieldMenu(String title, Runnable action, String defaultValue) {
        super(TextInputCreator.startTextField(defaultValue).withPromptText(title).buildTextField(), action);
    }

    public TextFieldMenu withPromptText(String promptText) {
        item.setPromptText(promptText);
        return this;
    }

    public TextFieldMenu withText(String text) {
        item.setText(text);
        return this;
    }

    public StringProperty text() {
        return item.textProperty();
    }
}
