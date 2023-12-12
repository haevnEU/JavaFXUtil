package de.haevn.jfx.properties;

import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class HavenStringProperty extends SimpleStringProperty {
    @Override
    public void set(String newValue) {
        Platform.runLater(() -> super.set(newValue));
    }

    @Override
    public void setValue(String v) {
        Platform.runLater(() -> super.setValue(v));
    }
}
