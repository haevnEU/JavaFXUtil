package de.haevn.jfx.tools.creation.elements;

import de.haevn.jfx.tools.creation.BaseCreator;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;


/**
 * This class is a builder for {@link CheckBox}
 *
 * @author haevn
 * @version 1.0
 * @see CheckBox
 * @since 1.1
 */
public class CheckBoxCreator implements ILabeledCreator {

    private final CheckBox obj = new CheckBox();
    private final BaseCreator<CheckBox> baseCreator;

    private CheckBoxCreator() {
        baseCreator = new BaseCreator<>(obj);
    }

    public static CheckBoxCreator start(final String title) {
        return new CheckBoxCreator().withText(title);
    }


    //----------------------------------------------------------------------------------------------------------------------
    // Methods from BaseCreator
    //----------------------------------------------------------------------------------------------------------------------

    public CheckBoxCreator withStyle(final String style) {
        baseCreator.withStyle(style);
        return this;
    }

    public CheckBoxCreator withStyleClass(final String... styleClass) {
        baseCreator.withStyleClass(styleClass);
        return this;
    }

    public CheckBoxCreator withId(final String id) {
        baseCreator.withId(id);
        return this;
    }

    public CheckBoxCreator withHeight(final double height) {
        baseCreator.withHeight(height);
        return this;
    }


    public CheckBoxCreator withDisable(boolean disable) {
        baseCreator.withDisable(disable);
        return this;
    }

    public CheckBoxCreator withWidth(final double width) {
        baseCreator.withWidth(width);
        return this;
    }


    //----------------------------------------------------------------------------------------------------------------------
    //  Concrete  methods for Checkbox
    //----------------------------------------------------------------------------------------------------------------------


    @Override
    public CheckBoxCreator withText(String text) {
        obj.setText(text);
        return this;
    }

    @Override
    public CheckBoxCreator withTextProperty(SimpleStringProperty textProperty) {
        obj.textProperty().bind(textProperty);
        return this;
    }

    public CheckBoxCreator withSelected(boolean selected) {
        obj.setSelected(selected);
        return this;
    }

    public CheckBoxCreator withToggleAction(Runnable action) {
        obj.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> action.run());
        return this;
    }

    public CheckBoxCreator withToggleAction(final ChangeListener<Boolean> action) {
        obj.selectedProperty().addListener(action);
        return this;
    }

    @Override
    public CheckBox build() {
        return obj;
    }
}
