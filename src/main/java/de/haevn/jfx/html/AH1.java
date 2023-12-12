package de.haevn.jfx.html;

import de.haevn.utils.network.NetworkInteraction;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;

public class AH1 extends Hyperlink {
    private SimpleStringProperty link = new SimpleStringProperty("");

    public AH1() {
        this("", "");
    }

    public AH1(String text, String link) {
        getStyleClass().add("html-ah1");
        setText(text);
        setLink(link);
        setStyle("-fx-font-size: 24;-fx-font-weight: bolder");
        setOnAction(this::openLink);
    }

    public SimpleStringProperty linkProperty() {
        return link;
    }

    public String getLink(){
        return link.get();
    }

    public void setLink(String link) {
        this.link.set(link);
    }

    private void openLink(ActionEvent event) {
        if (!link.get().isEmpty()) {
            NetworkInteraction.openWebsite(link.get());
        }
    }

}
