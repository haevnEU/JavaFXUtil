package de.haevn.jfx.properties;

import javafx.application.Platform;
import javafx.beans.property.*;

/**
 * javadoc is WIP
 * @version 1.0
 * @since 1.0
 * @author haevn
 */
public class HavenBooleanProperty extends SimpleBooleanProperty {
    @Override
    public void set(boolean newValue) {
        Platform.runLater(() -> super.set(newValue));
    }

    @Override
    public void setValue(Boolean v) {
        Platform.runLater(() -> super.setValue(v));
    }
}
