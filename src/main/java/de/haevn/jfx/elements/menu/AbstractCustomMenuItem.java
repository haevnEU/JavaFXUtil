package de.haevn.jfx.elements.menu;

import javafx.scene.control.Control;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public abstract class AbstractCustomMenuItem<T extends Control> extends Menu {
    protected T item;

    protected AbstractCustomMenuItem(T item, Runnable action) {
        MenuItem dummyItem = new MenuItem();
        dummyItem.setVisible(false);
        getItems().add(dummyItem);

        item.setOnMouseClicked(evt -> action.run());
        setGraphic(item);
        this.item = item;
    }
}
