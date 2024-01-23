package de.haevn.jfx.tools.creation.elements;

import de.haevn.jfx.tools.creation.BaseCreator;
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
public class TextInputCreator implements ILabeledCreator {
    private final TextInputControl obj;
    private final BaseCreator<TextInputControl> baseCreator;

    private TextInputCreator(TextInputControl obj) {
        this.obj = obj;
        baseCreator = new BaseCreator<>(obj);
    }

    public static TextInputCreator startTextField(final String title) {
        return new TextInputCreator(new TextField()).withText(title);
    }

    public static TextInputCreator startTextArea(final String title) {
        return new TextInputCreator(new TextArea()).withText(title);
    }

    //----------------------------------------------------------------------------------------------------------------------
    // Methods from BaseCreator
    //----------------------------------------------------------------------------------------------------------------------

    public TextInputCreator withStyle(final String style) {
        baseCreator.withStyle(style);
        return this;
    }

    public TextInputCreator withStyleClass(final String... styleClass) {
        baseCreator.withStyleClass(styleClass);
        return this;
    }

    public TextInputCreator withId(final String id) {
        baseCreator.withId(id);
        return this;
    }

    public TextInputCreator withHeight(final double height) {
        baseCreator.withHeight(height);
        return this;
    }


    public TextInputCreator withDisable(boolean disable) {
        baseCreator.withDisable(disable);
        return this;
    }

    public TextInputCreator withWidth(final double width) {
        baseCreator.withWidth(width);
        return this;
    }


    //----------------------------------------------------------------------------------------------------------------------
    //  Concrete Methods for TextInput
    //----------------------------------------------------------------------------------------------------------------------

    @Override
    public TextInputCreator withText(String text) {
        obj.setText(text);
        return this;
    }


    @Override
    public TextInputCreator withTextProperty(SimpleStringProperty textProperty) {
        obj.textProperty().bind(textProperty);
        return this;
    }

    @Override
    public TextInputControl build() {
        return obj;
    }
}
