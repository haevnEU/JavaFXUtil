package de.haevn.jfx.html;

import de.haevn.utils.network.NetworkInteraction;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;

/**
 * javadoc is WIP
 *
 * @author haevn
 * @version 1.0
 * @since 1.0
 */
public class AH2 extends Hyperlink {
    private final SimpleStringProperty link = new SimpleStringProperty("");

    public AH2() {
        this("", "");
    }

    public AH2(String text, String link) {
        getStyleClass().add("html-ah2");
        setText(text);
        setLink(link);
        setStyle("-fx-font-size: 20;-fx-font-weight: bolder");
        setOnAction(this::openLink);
    }

    public SimpleStringProperty linkProperty() {
        return link;
    }

    public String getLink() {
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
