package de.haevn.jfx.tools.creation.elements;

import de.haevn.jfx.tools.creation.BaseCreator;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;


/**
 * This class is a builder for {@link Label}
 *
 * @author haevn
 * @version 1.0
 * @see Label
 * @since 1.1
 */
public class LabelCreator extends BaseCreator<Label, LabelCreator> implements ILabeledCreator {

    private LabelCreator() {
        super(new Label());
        super.setInstance(this);
    }

    public static LabelCreator start(final String title) {
        return new LabelCreator().withText(title);
    }

    public static LabelCreator start(final SimpleStringProperty title) {
        return new LabelCreator().withTextProperty(title);
    }

    @Override
    public LabelCreator withText(String text) {
        object.setText(text);
        return this;
    }

    @Override
    public LabelCreator withTextProperty(SimpleStringProperty textProperty) {
        object.textProperty().bind(textProperty);
        return this;
    }
}
