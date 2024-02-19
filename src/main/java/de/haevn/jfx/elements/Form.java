package de.haevn.jfx.elements;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;


public class Form extends GridPane{

    public Form() {
        super();
        setHgap(10);
        setVgap(10);

    }


    public Form addRow(final String title, final Node value) {
        return addRow(new FormRow(title, value));
    }

    public Form addRow(final FormRow formRow) {
        final int row = getChildren().size();
        add(new Label(formRow.title), 0, row);
        add(formRow.value, 1, row);
        GridPane.setHgrow(formRow.value, Priority.ALWAYS);
        return this;
    }


    public static record FormRow(String title, Node value) {
    }
}
