package de.haevn.mvc;

/**
 * javadoc is WIP
 * @deprecated
 * @version 1.0
 * @since 1.0
 * @author haevn
 */
public interface IWidget {
    String getName();
    IController getController();
    IModel getModel();
    IView getView();

}
