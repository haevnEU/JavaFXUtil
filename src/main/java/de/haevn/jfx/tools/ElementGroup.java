package de.haevn.jfx.tools;


import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a simple class for grouping elements.
 * @version 1.0
 * @since 1.0
 * @author haevn
 *
 */
public class ElementGroup {
    private final List<Region> nodes = new ArrayList<>();

    public ElementGroup() {
    }

    public ElementGroup(final Region... nodes) {
        Collections.addAll(this.nodes, nodes);
    }

    public ElementGroup add(final Region node) {
        nodes.add(node);
        return this;
    }

    public ElementGroup addAll(final Region... nodes) {
        Collections.addAll(this.nodes, nodes);
        return this;
    }

    public ElementGroup remove(final Region node) {
        nodes.remove(node);
        return this;
    }

    public ElementGroup setEnabled(final boolean enabled) {
        nodes.forEach(node -> node.setDisable(!enabled));
        return this;
    }

    public ElementGroup setVisible(final boolean visible) {
        nodes.forEach(node -> node.setVisible(visible));
        return this;
    }

    public ElementGroup setStyle(final String style) {
        nodes.forEach(node -> node.setStyle(style));
        return this;
    }

    public ElementGroup setStyleClass(final String styleClass) {
        nodes.forEach(node -> node.getStyleClass().add(styleClass));
        return this;
    }

    public ElementGroup setStyleClass(final String... styleClasses) {
        nodes.forEach(node -> Collections.addAll(node.getStyleClass(), styleClasses));
        return this;
    }

    public ElementGroup setPadding(final double padding) {
        nodes.forEach(node -> node.setPadding(new Insets(padding)));
        return this;
    }

    public ElementGroup setPadding(final double top, final double right, final double bottom, final double left) {
        nodes.forEach(node -> node.setPadding(new Insets(top, right, bottom, left)));
        return this;
    }

    public ElementGroup setMaxWidth(final double width) {
        nodes.forEach(node -> node.setMaxWidth(width));
        return this;
    }

    public ElementGroup setMinWidth(final double width) {
        nodes.forEach(node -> node.setMinWidth(width));
        return this;
    }

    public ElementGroup setPrefWidth(final double width) {
        nodes.forEach(node -> node.setPrefWidth(width));
        return this;
    }

    public ElementGroup setFixedWidth(final double width) {
        nodes.forEach(node -> {
            node.setMinWidth(width);
            node.setMaxWidth(width);
            node.setPrefWidth(width);
        });
        return this;
    }

    public ElementGroup setMaxHeight(final double height) {
        nodes.forEach(node -> node.setMaxHeight(height));
        return this;
    }

    public ElementGroup setMinHeight(final double height) {
        nodes.forEach(node -> node.setMinHeight(height));
        return this;
    }

    public ElementGroup setPrefHeight(final double height) {
        nodes.forEach(node -> node.setPrefHeight(height));
        return this;
    }

    public ElementGroup setFixedHeight(final double height) {
        nodes.forEach(node -> {
            node.setMinHeight(height);
            node.setMaxHeight(height);
            node.setPrefHeight(height);
        });
        return this;
    }

    public ElementGroup setOnDragDetected(final EventHandler<? super MouseEvent> eventHandler) {
        nodes.forEach(node -> node.setOnDragDetected(eventHandler));
        return this;
    }

    public ElementGroup setOnDragDone(final EventHandler<? super DragEvent> eventHandler) {
        nodes.forEach(node -> node.setOnDragDone(eventHandler));
        return this;
    }

    public ElementGroup setOnDragEntered(final EventHandler<? super DragEvent> eventHandler) {
        nodes.forEach(node -> node.setOnDragEntered(eventHandler));
        return this;
    }

    public ElementGroup setOnDragExited(final EventHandler<? super DragEvent> eventHandler) {
        nodes.forEach(node -> node.setOnDragExited(eventHandler));
        return this;
    }

    public ElementGroup setOnDragOver(final EventHandler<? super DragEvent> eventHandler) {
        nodes.forEach(node -> node.setOnDragOver(eventHandler));
        return this;
    }

    public ElementGroup setOnDragDropped(final EventHandler<? super DragEvent> eventHandler) {
        nodes.forEach(node -> node.setOnDragDropped(eventHandler));
        return this;
    }

    public ElementGroup setOnMouseDragEntered(final EventHandler<? super MouseEvent> eventHandler) {
        nodes.forEach(node -> node.setOnMouseDragEntered(eventHandler));
        return this;
    }

    public ElementGroup setOnMouseDragExited(final EventHandler<? super MouseEvent> eventHandler) {
        nodes.forEach(node -> node.setOnMouseDragExited(eventHandler));
        return this;
    }

    public ElementGroup setOnMouseDragOver(final EventHandler<? super MouseEvent> eventHandler) {
        nodes.forEach(node -> node.setOnMouseDragOver(eventHandler));
        return this;
    }

    public ElementGroup setOnMouseDragReleased(final EventHandler<? super MouseEvent> eventHandler) {
        nodes.forEach(node -> node.setOnMouseDragReleased(eventHandler));
        return this;
    }

    public ElementGroup setOnMouseDragged(final EventHandler<? super MouseEvent> eventHandler) {
        nodes.forEach(node -> node.setOnMouseDragged(eventHandler));
        return this;
    }


    public ElementGroup setSnapToPixel(final boolean snapToPixel) {
        nodes.forEach(node -> node.setSnapToPixel(snapToPixel));
        return this;
    }

    public ElementGroup setOnKeyPressed(final EventHandler<? super KeyEvent> eventHandler) {
        nodes.forEach(node -> node.setOnKeyPressed(eventHandler));
        return this;
    }

    public ElementGroup setOnKeyReleased(final EventHandler<? super KeyEvent> eventHandler) {
        nodes.forEach(node -> node.setOnKeyReleased(eventHandler));
        return this;
    }

    public ElementGroup setOnKeyTyped(final EventHandler<? super KeyEvent> eventHandler) {
        nodes.forEach(node -> node.setOnKeyTyped(eventHandler));
        return this;
    }

    public ElementGroup setOnMouseClicked(final EventHandler<? super MouseEvent> eventHandler) {
        nodes.forEach(node -> node.setOnMouseClicked(eventHandler));
        return this;
    }

    public ElementGroup setOnMouseEntered(final EventHandler<? super MouseEvent> eventHandler) {
        nodes.forEach(node -> node.setOnMouseEntered(eventHandler));
        return this;
    }

    public ElementGroup setOnMouseExited(final EventHandler<? super MouseEvent> eventHandler) {
        nodes.forEach(node -> node.setOnMouseExited(eventHandler));
        return this;
    }

    public ElementGroup setOnMouseMoved(final EventHandler<? super MouseEvent> eventHandler) {
        nodes.forEach(node -> node.setOnMouseMoved(eventHandler));
        return this;
    }

    public ElementGroup setOnMousePressed(final EventHandler<? super MouseEvent> eventHandler) {
        nodes.forEach(node -> node.setOnMousePressed(eventHandler));
        return this;
    }

    public ElementGroup setOnMouseReleased(final EventHandler<? super MouseEvent> eventHandler) {
        nodes.forEach(node -> node.setOnMouseReleased(eventHandler));
        return this;
    }

    public ElementGroup setOnMouseLeftButtonClicked(final Runnable runnable) {
        nodes.forEach(node -> node.setOnMouseClicked(event -> {
            if (event.isPrimaryButtonDown()) {
                runnable.run();
            }
        }));
        return this;
    }

    public ElementGroup setOnMouseRightButtonClicked(final Runnable runnable) {
        nodes.forEach(node -> node.setOnMouseClicked(event -> {
            if (event.isSecondaryButtonDown()) {
                runnable.run();
            }
        }));
        return this;
    }

    public ElementGroup setOnMouseMiddleButtonClicked(final Runnable runnable) {
        nodes.forEach(node -> node.setOnMouseClicked(event -> {
            if (event.isMiddleButtonDown()) {
                runnable.run();
            }
        }));
        return this;
    }

    public ElementGroup setOnKeyPressed(final Runnable runnable, final KeyCode keyCode) {
        nodes.forEach(node -> node.setOnKeyPressed(event -> {
            if (event.getCode() == keyCode) {
                runnable.run();
            }
        }));
        return this;
    }


    public ElementGroup enable() {
        return setEnabled(true);
    }

    public ElementGroup disable() {
        return setEnabled(false);
    }

    public ElementGroup show() {
        return setVisible(true);
    }

    public ElementGroup hide() {
        return setVisible(false);
    }


    public List<Region> getElements() {
        return nodes;
    }

}
