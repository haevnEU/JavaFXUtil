package de.haevn.jfx.html;

import de.haevn.utils.network.NetworkInteraction;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;

/**
 * javadoc is WIP
 * @version 1.0
 * @since 1.0
 * @author haevn
 */
public class A extends Hyperlink {
    private String link;

    public A() {
        this("", "");
    }

    public A(String text, String link) {
        getStyleClass().add("html-text-link");
        setText(text);
        setLink(link);
        setOnAction(this::openLink);
    }

    public void setLink(String link) {
        this.link = link;
    }

    private void openLink(ActionEvent event) {
        if (!link.isEmpty()) {
            NetworkInteraction.openWebsite(link);
        }
    }

    public void setFontSize(int size) {
        setStyle("-fx-font-size: " + size + ";-fx-font-weight: italic;");
    }

}
