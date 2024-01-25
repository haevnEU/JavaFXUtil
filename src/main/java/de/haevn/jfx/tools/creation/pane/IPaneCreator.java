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
public interface IPaneCreator<T> {
    /**
     * Sets the width of the {@link Pane}
     *
     * @param padding the padding
     * @return the builder
     */
    IPaneCreator<T> withPadding(double padding);

    /**
     * Sets the width of the {@link Pane}
     *
     * @param top    the top padding
     * @param right  the right padding
     * @param bottom the bottom padding
     * @param left   the left padding
     * @return the builder
     */
    IPaneCreator<T> withPadding(double top, double right, double bottom, double left);

    /**
     * Sets the width of the {@link Pane}
     *
     * @param spacing the spacing
     * @return the builder
     */
    IPaneCreator<T> withSpacing(double spacing);
}
