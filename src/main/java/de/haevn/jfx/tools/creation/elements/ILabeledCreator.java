package de.haevn.jfx.tools.creation.elements;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Control;


/**
 * This class describes all methods for a builder for {@link Control}
 *
 * @author haevn
 * @version 1.0
 * @see Control
 * @since 1.1
 */
public interface ILabeledCreator {

    /**
     * Sets the text of the {@link Control}
     *
     * @param text the text
     * @return the builder
     */
    ILabeledCreator withText(final String text);

    /**
     * binds the text property of the {@link Control}
     *
     * @param textProperty the text
     * @return the builder
     */
    ILabeledCreator withTextProperty(final SimpleStringProperty textProperty);

    default ILabeledCreator withReadonly() {
        return this;
    }

}
