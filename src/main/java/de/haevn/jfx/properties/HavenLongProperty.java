package de.haevn.jfx.properties;

import javafx.application.Platform;
import javafx.beans.property.SimpleLongProperty;

/**
 * javadoc is WIP
 * @version 1.0
 * @since 1.0
 * @author haevn
 */
public class HavenLongProperty extends SimpleLongProperty {
    @Override
    public void set(long newValue) {
        Platform.runLater(() -> super.set(newValue));
    }

    @Override
    public void setValue(Number v) {
        Platform.runLater(() -> super.setValue(v));
    }
}
