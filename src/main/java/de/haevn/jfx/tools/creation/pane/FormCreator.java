package de.haevn.jfx.tools.creation.pane;

import de.haevn.jfx.tools.creation.BaseCreator;
import de.haevn.jfx.tools.creation.elements.LabelCreator;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

import java.util.Map;


/**
 * This class creates a Form layout based on a {@link GridPane}
 *
 * @author haevn
 * @version 1.0
 * @see GridPane
 * @since 1.1
 */
public class FormCreator extends BaseCreator<GridPane, FormCreator> implements IPaneCreator<GridPane> {
    private int rows = 0;

    private FormCreator() {
        super(new GridPane());
        super.setInstance(this);
        object.setHgap(10);
        object.setVgap(10);
    }

    public static FormCreator start() {
        return new FormCreator();
    }


    public FormCreator withDescriptionPercentageWidth(double percent) {
        if (percent > 100 || percent < 0) throw new IllegalArgumentException("Percent must be between 0 and 100");
        if (percent < 1) percent *= 100;
        ColumnConstraints firstColumnConstraints = new ColumnConstraints();
        firstColumnConstraints.setPercentWidth(percent);

        ColumnConstraints secondColumnConstraints = new ColumnConstraints();
        secondColumnConstraints.setPercentWidth(100 - percent);

        object.getColumnConstraints().addAll(firstColumnConstraints, secondColumnConstraints);
        return this;
    }

    public FormCreator withDescriptionFixedWidth(double percent) {
        ColumnConstraints firstColumnConstraints = new ColumnConstraints();
        firstColumnConstraints.setMinWidth(percent);
        firstColumnConstraints.setMaxWidth(percent);

        object.getColumnConstraints().addAll(firstColumnConstraints);
        return this;
    }

    public FormCreator addRow(final String title, final Node control) {
        return addRow(title, control, false);
    }

    public FormCreator addRow(final String title, final Node control, boolean expand) {
        final Label label = LabelCreator.start(title).withStyleClass("form-label").build();
        GridPane.setHalignment(label, HPos.LEFT);
        GridPane.setValignment(label, VPos.TOP);

        GridPane.setHalignment(control, HPos.LEFT);
        GridPane.setValignment(control, VPos.TOP);

        object.add(label, 0, rows);
        object.add(control, 1, rows);
        GridPane.setVgrow(control, expand ? javafx.scene.layout.Priority.ALWAYS : javafx.scene.layout.Priority.NEVER);
        GridPane.setHgrow(control, javafx.scene.layout.Priority.ALWAYS);
        rows++;
        return this;
    }

    public FormCreator withRows(Map<String, Node> entries) {
        entries.forEach(this::addRow);
        return this;
    }


    @Override
    public FormCreator withPadding(double padding) {
        return withPadding(padding, padding, padding, padding);
    }

    @Override
    public FormCreator withPadding(double top, double right, double bottom, double left) {
        object.setPadding(new Insets(top, right, bottom, left));
        return this;
    }

    @Override
    public FormCreator withSpacing(double spacing) {
        object.setHgap(10);
        object.setVgap(10);
        return this;
    }
}
