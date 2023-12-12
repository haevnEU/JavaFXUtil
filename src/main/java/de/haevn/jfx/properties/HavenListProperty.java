package de.haevn.jfx.properties;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;

import java.util.List;

public class HavenListProperty<E> extends SimpleListProperty<E> {
    @Override
    public void set(ObservableList<E> newValue) {
        Platform.runLater(() -> super.set(newValue));
    }

    @Override
    public void setValue(ObservableList<E> v) {
        Platform.runLater(() -> super.setValue(v));
    }
}
