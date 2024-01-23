package de.haevn.jfx.tools.creation.pane;

import javafx.scene.layout.Pane;

/**
 * This class describes all methods for a builder for {@link Pane}
 *
 * @author haevn
 * @version 1.0
 * @see Pane
 * @since 1.1
 */
public interface IPaneCreator {

    /**
     * Builds the pane
     *
     * @return the pane
     */
    Pane build();
}
