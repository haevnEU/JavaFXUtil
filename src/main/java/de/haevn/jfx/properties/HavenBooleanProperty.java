package de.haevn.jfx.properties;

import javafx.application.Platform;
import javafx.beans.property.*;

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
