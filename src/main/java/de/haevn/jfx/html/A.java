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
public class A extends Hyperlink {
    private final SimpleStringProperty link = new SimpleStringProperty("");

    public A() {
        this("", "");
    }

    public A(String text, String link) {
        this(text, link, 12);
    }

    private A(String text, String link, int fontSize) {
        setText(text);
        setLink(link);
        setFontSize(fontSize);
        setOnAction(this::openLink);
        getStyleClass().add("haevn-text");
    }

    public void setLink(String link) {
        this.link.set(link);
    }

    private void openLink(ActionEvent event) {
        if (!link.get().isEmpty()) {
            NetworkInteraction.openWebsite(link.get());
        }
    }

    public void setFontSize(int size) {
        setStyle("-fx-font-size: " + size);
    }


    public static A ofAH1(){
        return ofAH1("", "");
    }

    public static A ofAH2(){
        return ofAH2("", "");
    }

    public static A ofAH3(){
        return ofAH3("", "");
    }

    public static A ofAH4(){
        return ofAH4("", "");
    }

    public static A ofAH5(){
        return ofAH5("", "");
    }



    public static A ofAH1(String text, String link) {
        return new A(text, link, 24);
    }

    public static A ofAH2(String text, String link) {
        return new A(text, link, 20);
    }

    public static A ofAH3(String text, String link) {
        return new A(text, link, 18);
    }

    public static A ofAH4(String text, String link) {
        return new A(text, link, 16);
    }

    public static A ofAH5(String Text, String link) {
        return new A(Text, link, 14);
    }
}
