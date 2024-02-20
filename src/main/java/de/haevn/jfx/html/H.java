package de.haevn.jfx.html;

import javafx.scene.control.Label;

/**
 * javadoc is WIP
 *
 * @author haevn
 * @version 1.0
 * @since 1.0
 */
public class H extends Label {
    private H(final int size, final String text){
        setStyle("-fx-font-size: " + size + ";-fx-font-weight: bolder");
        getStyleClass().add("haevn-text");
        setText(text);
    }

    public static H ofH1(){
        return ofH1("");
    }

    public static H ofH2(){
        return ofH2("");
    }

    public static H ofH3(){
        return ofH3("");
    }

    public static H ofH4(){
        return ofH4("");
    }



    public static H ofH1(final String text){
        return new H(24, text);
    }

    public static H ofH2(final String text){
        return new H(20, text);
    }

    public static H ofH3(final String text){
        return new H(18, text);
    }

    public static H ofH4(final String text){
        return new H(16, text);
    }

}
