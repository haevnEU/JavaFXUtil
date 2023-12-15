package de.haevn.jfx.properties;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;

/**
 * javadoc is WIP
 * @version 1.0
 * @since 1.0
 * @author haevn
 */
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
