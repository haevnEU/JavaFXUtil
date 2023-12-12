package de.haevn.jfx.properties;

import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;

public class HavenFloatProperty extends SimpleFloatProperty {
    @Override
    public void set(float newValue) {
        Platform.runLater(() -> super.set(newValue));
    }

    @Override
    public void setValue(Number v) {
        Platform.runLater(() -> super.setValue(v));
    }
}
