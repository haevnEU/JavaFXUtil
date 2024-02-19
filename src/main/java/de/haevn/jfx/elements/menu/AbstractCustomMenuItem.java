package de.haevn.jfx.elements.menu;

import javafx.scene.control.Control;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public abstract class AbstractCustomMenuItem<T extends Control, K> extends Menu {
    protected T item;
    private K obj;

    protected AbstractCustomMenuItem(T item, Runnable action) {
        MenuItem placeholder = new MenuItem();
        placeholder.setVisible(false);
        getItems().add(placeholder);

        setStyle("-fx-padding: 0; -fx-spacing: 0; -fx-background-color: transparent;");


        item.setOnMouseClicked(evt -> action.run());
        setGraphic(item);
        this.item = item;
    }

    protected void setReference(K reference){
        this.obj = reference;
    }

    public K withDisabled(){
        setDisable(true);
        return obj;
    }

    public K enable(){
        setDisable(false);
        return obj;
    }

    public K disable(){
        return withDisabled();
    }
}
