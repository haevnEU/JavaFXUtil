package de.haevn.jfx.properties;

import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * javadoc is WIP
 * @version 1.0
 * @since 1.0
 * @author haevn
 */
public class HavenIntegerProperty extends SimpleIntegerProperty {
    @Override
    public void set(int newValue) {
        Platform.runLater(() -> super.set(newValue));
    }

    @Override
    public void setValue(Number v) {
        Platform.runLater(() -> super.setValue(v));
    }
}
