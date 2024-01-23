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
public class LabelCreator implements ILabeledCreator {
    private final Label label = new Label();
    private final BaseCreator<Label> baseCreator;

    private LabelCreator() {
        baseCreator = new BaseCreator<>(label);
    }

    public static LabelCreator start(final String title) {
        return new LabelCreator().withText(title);
    }

    //----------------------------------------------------------------------------------------------------------------------
    // Methods from BaseCreator
    //----------------------------------------------------------------------------------------------------------------------

    public LabelCreator withStyle(final String style) {
        baseCreator.withStyle(style);
        return this;
    }

    public LabelCreator withStyleClass(final String... styleClass) {
        baseCreator.withStyleClass(styleClass);
        return this;
    }

    public LabelCreator withId(final String id) {
        baseCreator.withId(id);
        return this;
    }

    public LabelCreator withHeight(final double height) {
        baseCreator.withHeight(height);
        return this;
    }


    public LabelCreator withDisable(boolean disable) {
        baseCreator.withDisable(disable);
        return this;
    }

    public LabelCreator withWidth(final double width) {
        baseCreator.withWidth(width);
        return this;
    }

    //----------------------------------------------------------------------------------------------------------------------
    //  Concrete  methods for Label
    //----------------------------------------------------------------------------------------------------------------------

    @Override
    public LabelCreator withText(String text) {
        label.setText(text);
        return this;
    }

    @Override
    public LabelCreator withTextProperty(SimpleStringProperty textProperty) {
        label.textProperty().bind(textProperty);
        return this;
    }

    @Override
    public Label build() {
        return label;
    }
}
