package de.haevn.jfx.elements.menu;

import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.scene.control.CheckBox;

public class CheckBoxMenu extends AbstractCustomMenuItem<CheckBox> {
    public CheckBoxMenu(String title, Runnable action) {
        super(new CheckBox(), action);

    }

    public boolean isSelected() {
        return item.isSelected();
    }

    public CheckBoxMenu setSelected(boolean selected) {
        item.setSelected(selected);
        return this;
    }

    public CheckBoxMenu setIndeterminate(boolean indeterminate) {
        item.setIndeterminate(indeterminate);
        return this;
    }

    public boolean isIndeterminate() {
        return item.isIndeterminate();
    }

    public ReadOnlyBooleanProperty valueProperty() {
        return item.selectedProperty();
    }
}
