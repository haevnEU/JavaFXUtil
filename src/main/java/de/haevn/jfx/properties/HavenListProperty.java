package de.haevn.jfx.properties;

import javafx.application.Platform;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;

/**
 * javadoc is WIP
 * @version 1.0
 * @since 1.0
 * @author haevn
 */
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
