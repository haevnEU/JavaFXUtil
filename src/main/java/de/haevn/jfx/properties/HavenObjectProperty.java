package de.haevn.jfx.properties;

import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;

public class HavenObjectProperty<T> extends SimpleObjectProperty<T>{
    @Override
    public void set(T newValue) {
        Platform.runLater(() -> super.set(newValue));
    }

    @Override
    public void setValue(T v) {
        Platform.runLater(() -> super.setValue(v));
    }
}
