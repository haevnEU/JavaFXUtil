package de.haevn.jfx.properties;

import javafx.application.Platform;
import javafx.beans.property.SimpleMapProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.collections.ObservableMap;
import javafx.collections.ObservableSet;

public class HavenSetProperty<E> extends SimpleSetProperty<E> {
    @Override
    public void set(ObservableSet<E> newValue) {
        Platform.runLater(() -> super.set(newValue));
    }

    @Override
    public void setValue(ObservableSet<E> v) {
        Platform.runLater(() -> super.setValue(v));
    }
}
