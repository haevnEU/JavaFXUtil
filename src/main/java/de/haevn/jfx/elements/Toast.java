package de.haevn.jfx.elements;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * javadoc is WIP
 * @version 1.0
 * @since 1.0
 * @author haevn
 */
public class Toast {
    private final Stage stage = new Stage();
    private final SimpleIntegerProperty duration = new SimpleIntegerProperty(5000);
    private final Deque<ToastContainer> stack = new ArrayDeque<>();
    private final ToastContainer[] containers = new ToastContainer[5];
    private static final Toast INSTANCE = new Toast();

    public static synchronized Toast getInstance() {
        return INSTANCE;
    }


    private Stage owner;
    public Toast changeOwner(final Stage owner){
        this.owner = owner;
        stage.initOwner(owner);
        owner.xProperty().addListener((observable, oldValue, newValue) -> {
            int id = 0;
            for (ToastContainer container : stack) {
                container.render(id);
                id++;
            }
        });
        owner.yProperty().addListener((observable, oldValue, newValue) -> {
            int id = 0;
            for (ToastContainer container : stack) {
                container.render(id);
                id++;
            }
        });
        
        return this;
    }

    public void message(final String message){
        toastIt(message, Type.INFO);
    }

    public void bad(final String message){
        toastIt(message, Type.ERROR);
    }

    public void good(final String message){
        toastIt(message, Type.SUCCESS);
    }

    public void warn(final String message){
        toastIt(message, Type.WARNING);
    }



    public void toastIt(final String message, final Type type) {
        if(null == owner){
            return;
        }
        ToastContainer toastContainer = new ToastContainer(message, type, owner);

        stack.add(toastContainer);
        toastContainer.render(stack.size());

    }

    private class ToastContainer{
        final Stage owner;
        final Stage toastStage = new Stage();

        ToastContainer(final String message, final Type type, final Stage owner){
            this.owner = owner;
            toastStage.initOwner(owner);
            toastStage.setResizable(false);
            toastStage.initStyle(StageStyle.TRANSPARENT);

            final Text text = new Text(message);
            final StackPane root = new StackPane(text);
            root.getStyleClass().add(type.styleClass);

            final Scene scene = new Scene(root, 200, 50);
            scene.setFill(Color.TRANSPARENT);
            scene.getStylesheets().add("core.css");
            toastStage.setScene(scene);
            toastStage.show();

            final Duration fadeDuration = new Duration(500);
            final Duration toastDelay = new Duration(duration.get());
            
            final FadeTransition inTransition = new FadeTransition(fadeDuration, toastStage.getScene().getRoot());
            inTransition.setFromValue(0.0);
            inTransition.setToValue(1);

            final FadeTransition outTransition = new FadeTransition(fadeDuration, toastStage.getScene().getRoot());
            outTransition.setFromValue(1.0);
            outTransition.setToValue(0);

            final PauseTransition pauseTransition = new PauseTransition(toastDelay);

            final SequentialTransition mainTransition = new SequentialTransition(inTransition, pauseTransition, outTransition);
            mainTransition.setOnFinished(this::onHide);
            mainTransition.play();

        }

        private void onHide(ActionEvent ignored) {
            toastStage.close();
            stack.remove(this);
        }

        public void render(final int id){
            System.out.println(id);
            if(null != owner) {
                toastStage.setX(owner.getX() + owner.getWidth() - 220);
                toastStage.setY(owner.getY() + owner.getHeight() - 70 * id);
            }
        }

    }

    public enum Type{
        INFO("info"),
        ERROR("error"),
        WARNING("warning"),
        SUCCESS("success");

        private final String styleClass;
        private Type(final String css){
            this.styleClass = "toast-" + css;
        }
    }

}
