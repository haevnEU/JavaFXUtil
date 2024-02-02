package de.haevn.jfx.tools;


import de.haevn.jfx.elements.menu.SliderMenu;
import javafx.scene.control.Control;
import javafx.scene.layout.Region;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ElementGroup {
    private final List<Region> nodes = new ArrayList<>();

    public ElementGroup() {
    }

    public ElementGroup(Control... nodes) {
        Collections.addAll(this.nodes, nodes);
    }

    public ElementGroup add(Control node) {
        nodes.add(node);
        return this;
    }

    public ElementGroup addAll(Control... nodes) {
        Collections.addAll(this.nodes, nodes);
        return this;
    }

    public ElementGroup remove(Control node) {
        nodes.remove(node);
        return this;
    }

    public ElementGroup setEnabled(boolean enabled) {
        nodes.forEach(node -> node.setDisable(!enabled));
        return this;
    }

    public ElementGroup setVisible(boolean visible) {
        nodes.forEach(node -> node.setVisible(visible));
        return this;
    }

    public ElementGroup setStyle(String style) {
        nodes.forEach(node -> node.setStyle(style));
        return this;
    }

    public ElementGroup setStyleClass(String styleClass) {
        nodes.forEach(node -> node.getStyleClass().add(styleClass));
        return this;
    }

    public ElementGroup setStyleClass(String... styleClasses) {
        nodes.forEach(node -> Collections.addAll(node.getStyleClass(), styleClasses));
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
