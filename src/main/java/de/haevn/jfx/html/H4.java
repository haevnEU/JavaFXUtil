package de.haevn.jfx.html;


/**
 * javadoc is WIP
 *
 * @author haevn
 * @version 1.0
 * @since 1.0
 */
public class H4 extends H {
    public H4() {
        this("");
    }

    public H4(String text) {
        getStyleClass().add("html-h4");
        setText(text);
        setStyle("-fx-font-size: 16;-fx-font-weight: bolder");
    }
}
