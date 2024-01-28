package de.haevn.jfx.tools.creation;

import javafx.scene.layout.Region;

/**
 * This class describes all methods for a builder for {@link Region}
 * @param <T> the type of the {@link Region}
 * @version 1.0
 * @since 1.1
 * @see Region
 * @author haevn
 */
public abstract class BaseCreator<T extends Region, K> {

    protected final T object;
    protected K instance;
    protected BaseCreator(T value) {
        this.object = value;
    }

    protected void setInstance(K instance) {
        this.instance = instance;
    }

    /**
     * Sets the width of the {@link Region}
     * @param width the width
     */
    public K withWidth(double width) {
        object.setMinWidth(width);
        object.setMaxWidth(width);
        return instance;
    }

    /**
     * Sets the height of the {@link Region}
     * @param height the height
     */
    public K withHeight(double height) {
        object.setMinHeight(height);
        object.setMaxHeight(height);
        return instance;
    }

    /**
     * Sets the disable property of the {@link Region}
     * @param disable the disable property
     */
    public K withDisable(boolean disable) {
        object.setDisable(disable);
        return instance;
    }

    /**
     * Sets the id of the {@link Region}
     * @param id the id
     */
    public K withId(String id) {
        object.setId(id);
        return instance;
    }

    /**
     * Sets the style class of the {@link Region}
     * @param styleClass the style class
     */
    public K withStyleClass(String... styleClass) {
        object.getStyleClass().addAll(styleClass);
        return instance;
    }

    /**
     * Sets the style of the {@link Region}
     * @param style the style
     */
    public K withStyle(String style) {
        object.setStyle(style);
        return instance;
    }


    public T build() {
        return object;
    }
}
