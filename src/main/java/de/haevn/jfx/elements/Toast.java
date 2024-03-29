package de.haevn.jfx.elements;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * javadoc is WIP
 *
 * @author haevn
 * @version 1.0
 * @since 1.0
 */
public class Toast {

    private static Toast toasting_instance = new Toast();
    private final Stage stage = new Stage();
    private final Deque<ToastContainer> stack = new ArrayDeque<>();

    private Toast(final Stage owner) {
        stage.initOwner(owner);
        owner.xProperty().addListener((observable, oldValue, newValue) -> toasting_instance.render());
        owner.yProperty().addListener((observable, oldValue, newValue) -> toasting_instance.render());
        owner.widthProperty().addListener((observable, oldValue, newValue) -> toasting_instance.render());
        owner.heightProperty().addListener((observable, oldValue, newValue) -> toasting_instance.render());
    }

    private Toast() {
    }

    public static void initialize(final Stage owner) {
        toasting_instance = new Toast(owner);
    }

    public static void message(final String message) {
        internalToastIt(message, Type.INFO, ToastDuration.NORMAL);
    }

    public static void message(final String message, ToastDuration duration) {
        internalToastIt(message, Type.INFO, duration);
    }

    public static void bad(final String message) {
        internalToastIt(message, Type.ERROR, ToastDuration.NORMAL);
    }

    public static void bad(final String message, ToastDuration duration) {
        internalToastIt(message, Type.ERROR, duration);
    }

    public static void good(final String message) {
        internalToastIt(message, Type.SUCCESS, ToastDuration.NORMAL);
    }

    public static void good(final String message, ToastDuration duration) {
        internalToastIt(message, Type.SUCCESS, duration);
    }

    public static void warn(final String message) {
        internalToastIt(message, Type.WARNING, ToastDuration.NORMAL);
    }

    public static void warn(final String message, ToastDuration duration) {
        internalToastIt(message, Type.WARNING, duration);
    }

    private static void internalToastIt(final String message, final Type type, ToastDuration duration) {
        if (null == toasting_instance) throw new IllegalStateException("Toast not initialized");
        toasting_instance.toastIt(message, type, duration);

    }

    private void render() {
        int id = 1;
        for (final ToastContainer container : stack) {
            container.render(id);
            id++;
        }
    }


    private void toastIt(final String message, final Type type, ToastDuration duration) {
        Platform.runLater(() -> {
            final ToastContainer toastContainer = new ToastContainer(message, type, duration);
            stack.add(toastContainer);
            toastContainer.render(stack.size());
            toastContainer.hidden.addListener((observable, oldValue, newValue) -> {
                stack.remove(toastContainer);
                render();
            });
        });
    }

    public enum ToastDuration {
        SHORT(2000),
        NORMAL(3000),
        MEDIUM(5000),
        LONG(10000);

        private final int duration;

        ToastDuration(final int duration) {
            this.duration = duration;
        }
    }


    private enum Type {
        INFO("info"),
        ERROR("error"),
        WARNING("warning"),
        SUCCESS("success");

        private final String styleClass;

        Type(final String css) {
            this.styleClass = "toast-" + css;
        }
    }

    private static final class ToastContainer {
        private static final int WIDTH = 300;
        private static final int HEIGHT = 50;
        final Stage toastStage = new Stage();
        private final SimpleBooleanProperty hidden = new SimpleBooleanProperty(false);

        ToastContainer(final String message, final Type type, ToastDuration duration) {
            toastStage.initOwner(toasting_instance.stage.getOwner());
            toastStage.setResizable(false);
            toastStage.initStyle(StageStyle.TRANSPARENT);

            final Text text = new Text(message);
            final StackPane root = new StackPane(text);
            root.getStyleClass().add(type.styleClass);
            text.getStyleClass().add(type.styleClass);

            final Scene scene = new Scene(root, WIDTH, HEIGHT);
            scene.setFill(Color.TRANSPARENT);
            scene.getStylesheets().add("core.css");
            toastStage.setScene(scene);
            toastStage.show();

            final Duration fadeDuration = new Duration(500);
            final Duration toastDelay = new Duration(duration.duration);

            final SequentialTransition mainTransition = getTransition(fadeDuration, toastDelay);
            mainTransition.play();

        }


        @NotNull
        private SequentialTransition getTransition(Duration fadeDuration, Duration toastDelay) {
            final FadeTransition inTransition = new FadeTransition(fadeDuration, toastStage.getScene().getRoot());
            inTransition.setFromValue(0.0);
            inTransition.setToValue(1);

            final FadeTransition outTransition = new FadeTransition(fadeDuration, toastStage.getScene().getRoot());
            outTransition.setFromValue(1.0);
            outTransition.setToValue(0);

            final PauseTransition pauseTransition = new PauseTransition(toastDelay);

            final SequentialTransition mainTransition = new SequentialTransition(inTransition, pauseTransition, outTransition);
            mainTransition.setOnFinished(this::onHide);
            return mainTransition;
        }

        private void onHide(ActionEvent ignored) {
            hidden.set(true);
            toastStage.close();
        }

        public void render(final int id) {
            final var owner = toasting_instance.stage.getOwner();
            toastStage.setX(owner.getX() + owner.getWidth() - (WIDTH + 20));
            toastStage.setY(owner.getY() + owner.getHeight() - (HEIGHT + 10) * id - 10);
        }

    }

}
