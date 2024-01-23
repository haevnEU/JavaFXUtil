package de.haevn.jfx.tools.creation.pane;

import de.haevn.jfx.tools.creation.BaseCreator;
import de.haevn.jfx.tools.creation.elements.LabelCreator;
import javafx.geometry.HPos;
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
public class FormCreator {
    private final GridPane root = new GridPane();
    final BaseCreator<GridPane> baseCreator = new BaseCreator<>(root);
    private int rows = 0;

    private FormCreator() {
        root.setHgap(10);
        root.setVgap(10);
    }

    public static FormCreator start() {
        return new FormCreator();
    }

    //----------------------------------------------------------------------------------------------------------------------
    // Methods from BaseCreator
    //----------------------------------------------------------------------------------------------------------------------

    public FormCreator withStyle(final String style) {
        baseCreator.withStyle(style);
        return this;
    }

    public FormCreator withStyleClass(final String... styleClass) {
        baseCreator.withStyleClass(styleClass);
        return this;
    }

    public FormCreator withId(final String id) {
        baseCreator.withId(id);
        return this;
    }

    public FormCreator withHeight(final double height) {
        baseCreator.withHeight(height);
        return this;
    }


    public FormCreator withDisable(boolean disable) {
        baseCreator.withDisable(disable);
        return this;
    }

    public FormCreator withWidth(final double width) {
        baseCreator.withWidth(width);
        return this;
    }


    //----------------------------------------------------------------------------------------------------------------------
    //  Concrete  methods for the Form
    //----------------------------------------------------------------------------------------------------------------------

    public FormCreator withDescriptionPercentageWidth(double percent) {
        if (percent > 100 || percent < 0) throw new IllegalArgumentException("Percent must be between 0 and 100");
        if (percent < 1) percent *= 100;
        ColumnConstraints firstColumnConstraints = new ColumnConstraints();
        firstColumnConstraints.setPercentWidth(percent);

        ColumnConstraints secondColumnConstraints = new ColumnConstraints();
        secondColumnConstraints.setPercentWidth(100 - percent);

        root.getColumnConstraints().addAll(firstColumnConstraints, secondColumnConstraints);
        return this;
    }

    public FormCreator withDescriptionFixedWidth(double percent) {
        ColumnConstraints firstColumnConstraints = new ColumnConstraints();
        firstColumnConstraints.setMinWidth(percent);
        firstColumnConstraints.setMaxWidth(percent);

        root.getColumnConstraints().addAll(firstColumnConstraints);
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

        root.add(label, 0, rows);
        root.add(control, 1, rows);
        GridPane.setVgrow(control, expand ? javafx.scene.layout.Priority.ALWAYS : javafx.scene.layout.Priority.NEVER);
        GridPane.setHgrow(control, javafx.scene.layout.Priority.ALWAYS);
        rows++;
        return this;
    }

    public FormCreator withRows(Map<String, Node> entries) {
        entries.forEach(this::addRow);
        return this;
    }

    public GridPane build() {
        return root;
    }
}
