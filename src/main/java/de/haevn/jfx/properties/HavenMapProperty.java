package de.haevn.jfx.properties;

import javafx.application.Platform;
import javafx.beans.property.SimpleMapProperty;
import javafx.collections.ObservableMap;

/**
 * javadoc is WIP
 * @version 1.0
 * @since 1.0
 * @author haevn
 */
public class HavenMapProperty<K, V> extends SimpleMapProperty<K, V> {
    @Override
    public void set(ObservableMap<K, V> newValue) {
        Platform.runLater(() -> super.set(newValue));
    }

    @Override
    public void setValue(ObservableMap<K, V> v) {
        Platform.runLater(() -> super.setValue(v));
    }
}
