package de.haevn.jfx.elements.container;

import de.haevn.utils.datastructure.SearchableList;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SearchableContainer<T> extends ScrollPane {
    private final SearchableList<T> items = new SearchableList<>();
    private Predicate<T> currentQuery = t -> true;
    final VBox root = new VBox();

    private final Function<T, Node> nodeBuilder;

    public SearchableContainer(final Function<T, Node> nodeBuilder) {
        this.nodeBuilder = nodeBuilder;
        setContent(root);
        setFitToWidth(true);
        setFitToHeight(true);
        setStyle("-fx-background: transparent; -fx-background-color: transparent;");
        root.setStyle("-fx-background: transparent; -fx-background-color: transparent;");
        setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        setVbarPolicy(ScrollBarPolicy.NEVER);
    }

    public SearchableContainer addAll(final T... items) {
        return addAll(List.of(items));
    }

    public SearchableContainer addAll(final List<T> item) {
        items.addAll(item);
        return this;
    }

    public SearchableContainer add(final T item) {
        items.add(item);
        return this;
    }

    public void search(final Predicate<T> query) {
        currentQuery = query;
        update();
    }

    public void reset() {
        currentQuery = t -> true;
        update();
    }

    public void update() {
        root.getChildren().clear();
        root.getChildren().addAll(items.search(currentQuery).stream().map(nodeBuilder).toList());
    }

    public void apply(Consumer<T> consumer) {
        items.forEach(consumer);
    }

}
