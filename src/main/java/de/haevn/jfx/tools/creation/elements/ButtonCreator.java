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
public final class ButtonCreator extends BaseCreator<Button, ButtonCreator> implements ILabeledCreator {

    private ButtonCreator() {
        super(new Button());
        super.setInstance(this);
    }

    public static ButtonCreator start(final String title) {
        return new ButtonCreator().withText(title);
    }

    @Override
    public ILabeledCreator withTextProperty(SimpleStringProperty textProperty) {
        object.textProperty().bind(textProperty);
        return this;
    }

    @Override
    public ButtonCreator withText(String text) {
        object.setText(text);
        return this;
    }

    public ButtonCreator withOnClick(final Runnable event) {
        object.setOnAction(e -> event.run());
        return this;
    }

    @Override
    public ButtonCreator withReadonly() {
        object.setDisable(true);
        return this;
    }

    public ButtonCreator withOnClick(final EventHandler<ActionEvent> event) {
        object.setOnAction(event);
        return this;
    }
}
