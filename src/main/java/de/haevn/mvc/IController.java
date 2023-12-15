package de.haevn.mvc;


/**
 * javadoc is WIP
 * @deprecated
 * @version 1.0
 * @since 1.0
 * @author haevn
 */
public interface IController {

    void link(IView view);
    default void link(IView view, IModel model){}
}
