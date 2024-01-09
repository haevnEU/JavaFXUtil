package de.haevn.jfx.html;

/**
 * javadoc is WIP
 *
 * @author haevn
 * @version 1.0
 * @since 1.0
 */
public class H2 extends H {
    public H2() {
        this("");
    }

    public H2(String text) {
        getStyleClass().add("html-h2");
        setText(text);
        setStyle("-fx-font-size: 20;-fx-font-weight: bolder");
    }
}
