package de.haevn.jfx.elements;

import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class Toast {
    private SimpleBooleanProperty visible = new SimpleBooleanProperty(false);
    private final Pane pane = new Pane();
    private long duration = 3000;
    private final Label content = new Label();
    public Toast() {
       pane.getChildren().add(content);
         pane.setVisible(false);
         visible.addListener((observable, oldValue, newValue) -> pane.setVisible(newValue));
    }

    public Pane get(){
        return pane;
    }

    public Toast start(){
        return this;
    }

    public Toast duration(long duration){
        this.duration = duration;
        return this;
    }

    public Toast message(String message){
        content.setText(message);
        return  this;
    }


    public void toastIt(){
        visible.set(true);
        Platform.runLater(() -> {
            try {
                Thread.sleep(duration);
                visible.set(false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }



}
