package de.haevn.jfx.tools.creation.elements;

import de.haevn.jfx.tools.creation.BaseCreator;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


/**
 * This class is a builder for {@link Button}
 *
 * @author haevn
 * @version 1.0
 * @see Button
 * @since 1.1
 */
public final class ButtonCreator implements ILabeledCreator {
    private final Button button = new Button();
    private final BaseCreator<Button> baseCreator;

    private ButtonCreator() {
        baseCreator = new BaseCreator<>(button);
    }


    public static ButtonCreator start(final String title) {
        return new ButtonCreator().withText(title);
    }
    //----------------------------------------------------------------------------------------------------------------------
    // Methods from BaseCreator
    //----------------------------------------------------------------------------------------------------------------------

    public ButtonCreator withStyle(final String style) {
        baseCreator.withStyle(style);
        return this;
    }

    public ButtonCreator withStyleClass(final String... styleClass) {
        baseCreator.withStyleClass(styleClass);
        return this;
    }

    public ButtonCreator withId(final String id) {
        baseCreator.withId(id);
        return this;
    }

    public ButtonCreator withHeight(final double height) {
        baseCreator.withHeight(height);
        return this;
    }


    public ButtonCreator withDisable(boolean disable) {
        baseCreator.withDisable(disable);
        return this;
    }

    public ButtonCreator withWidth(final double width) {
        baseCreator.withWidth(width);
        return this;
    }

    //----------------------------------------------------------------------------------------------------------------------
    //  Concrete  methods for Button
    //----------------------------------------------------------------------------------------------------------------------


    @Override
    public ILabeledCreator withTextProperty(SimpleStringProperty textProperty) {
        button.textProperty().bind(textProperty);
        return this;
    }

    @Override
    public ButtonCreator withText(String text) {
        button.setText(text);
        return this;
    }

    public ButtonCreator withOnClick(final Runnable event) {
        button.setOnAction(e -> event.run());
        return this;
    }

    public ButtonCreator withOnClick(final EventHandler<ActionEvent> event) {
        button.setOnAction(event);
        return this;
    }

    public Button build() {
        return button;
    }

}
