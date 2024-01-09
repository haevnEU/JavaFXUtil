package de.haevn.jfx.html;

/**
 * javadoc is WIP
 *
 * @author haevn
 * @version 1.0
 * @since 1.0
 */
public class H3 extends H {
    public H3() {
        this("");
    }

    public H3(String text) {
        getStyleClass().add("html-h3");
        setText(text);
        setStyle("-fx-font-size: 18;-fx-font-weight: bolder");
    }
}
