package de.haevn.jfx.elements;


import de.haevn.jfx.html.AH1;
import de.haevn.jfx.html.H1;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class HeaderPane extends VBox {
    private Pane content = null;
    public HeaderPane(final String title) {
        this(new H1(title));
    }

    public HeaderPane(final String title, final String link) {
        this(new AH1(title, link));
    }

    private HeaderPane(final Node title){
        super.getChildren().add(title);
        setSpacing(10);
        setPadding(new Insets(10, 10, 10, 10));
    }

    public void setContent(final Pane content) {
        if(this.content != null){
            super.getChildren().remove(this.content);
        }
        this.content = content;
        super.getChildren().add(content);
    }

    public Pane getContent() {
        return content;
    }

    @Override
    public ObservableList<Node> getChildren() {
        return content.getChildren();
    }
}
