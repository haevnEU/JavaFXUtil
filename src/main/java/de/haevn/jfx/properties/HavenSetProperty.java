package de.haevn.jfx.properties;

import javafx.application.Platform;
import javafx.beans.property.SimpleSetProperty;
import javafx.collections.ObservableSet;

/**
 * javadoc is WIP
 * @version 1.0
 * @since 1.0
 * @author haevn
 */
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
