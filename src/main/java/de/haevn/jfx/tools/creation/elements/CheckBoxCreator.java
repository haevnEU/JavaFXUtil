package de.haevn.jfx.tools.creation.elements;

import de.haevn.jfx.tools.creation.BaseCreator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;


/**
 * This class is a builder for {@link CheckBox}
 *
 * @author haevn
 * @version 1.0
 * @see CheckBox
 * @since 1.1
 */
public class CheckBoxCreator extends BaseCreator<CheckBox, CheckBoxCreator> implements ILabeledCreator {

    private Property<Boolean> selectedProperty = null;
    private ChangeListener<Boolean> changeListener = null;

    private CheckBoxCreator() {
        super(new CheckBox());
        super.setInstance(this);
    }

    public static CheckBoxCreator start(final String title) {
        return new CheckBoxCreator().withText(title);
    }

    @Override
    public CheckBoxCreator withText(String text) {
        object.setText(text);
        return this;
    }

    @Override
    public CheckBoxCreator withTextProperty(SimpleStringProperty textProperty) {
        object.textProperty().bind(textProperty);
        return this;
    }

    public CheckBoxCreator withSelected(boolean selected) {
        object.setSelected(selected);
        return this;
    }

    public CheckBoxCreator withSelectedProperty(BooleanProperty selectedProperty) {
        this.selectedProperty = selectedProperty;
        return this;
    }

    public CheckBoxCreator withSelectionChanged(final Runnable event) {
        changeListener = (observable, oldValue, newValue) -> event.run();
        return this;
    }

    public CheckBoxCreator withSelectionChanged(final ChangeListener<Boolean> event) {
        changeListener = event;
        return this;
    }

    public CheckBoxCreator withIndeterminate(boolean indeterminate) {
        object.setIndeterminate(indeterminate);
        return this;
    }

    @Override
    public CheckBoxCreator withReadonly() {
        object.setDisable(true);
        return this;
    }

    @Override
    public CheckBox build() {
        if (null != selectedProperty) object.selectedProperty().bindBidirectional(selectedProperty);
        if (null != changeListener) object.selectedProperty().addListener(changeListener);
        return super.build();
    }

    public HBox buildWIthBox(final boolean isLeft) {
        final Label title = LabelCreator.start(object.getText()).build();
        object.setText("");
        final var box = isLeft ? new HBox(build(), title) : new HBox(title, build());
        box.setSpacing(10);
        return box;
    }
}
