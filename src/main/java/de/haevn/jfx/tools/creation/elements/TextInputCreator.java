package de.haevn.jfx.tools.creation.elements;

import de.haevn.jfx.tools.creation.BaseCreator;
import de.haevn.utils.exceptions.InvalidCastException;
import de.haevn.utils.exceptions.MethodNotAllowedError;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;


/**
 * This class is a builder for {@link TextInputControl}.
 * Note it can be used for {@link TextField} and {@link TextArea}
 *
 * @author haevn
 * @version 1.0
 * @see TextInputControl
 * @see TextField
 * @see TextArea
 * @since 1.1
 */
public class TextInputCreator extends BaseCreator<TextInputControl, TextInputCreator> implements ILabeledCreator {

    private TextInputCreator(TextInputControl obj) {
        super(obj);
        super.setInstance(this);
    }

    public static TextInputCreator startTextField(final String title) {
        return new TextInputCreator(new TextField()).withText(title);
    }

    public static TextInputCreator startTextArea(final String title) {
        return new TextInputCreator(new TextArea()).withText(title);
    }


    @Override
    public TextInputCreator withText(String text) {
        object.setText(text);
        return this;
    }

    @Override
    public TextInputCreator withTextProperty(SimpleStringProperty textProperty) {
        object.textProperty().bind(textProperty);
        return this;
    }

    public TextInputCreator withPromptText(String promptText) {
        object.setPromptText(promptText);
        return this;
    }

    public TextInputCreator withEditable(boolean editable) {
        object.setEditable(editable);
        return this;
    }

    @Override
    public TextInputCreator withReadonly() {
        object.setEditable(false);
        return this;
    }

    @Override
    public TextInputControl build() {
        throw new MethodNotAllowedError();
    }

    public TextField buildTextField() throws InvalidCastException {
        if (object instanceof TextField returnObject) return returnObject;
        throw new InvalidCastException(object.getClass(), TextField.class);
    }

    public TextArea buildTextArea() throws InvalidCastException {
        if (object instanceof TextArea returnObject) return returnObject;
        throw new InvalidCastException(object.getClass(), TextArea.class);
    }
}
