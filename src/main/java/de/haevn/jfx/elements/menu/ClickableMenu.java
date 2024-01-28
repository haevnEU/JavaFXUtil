package de.haevn.jfx.elements.menu;

import javafx.scene.control.Label;

public class ClickableMenu extends AbstractCustomMenuItem<Label, ClickableMenu> {
    public ClickableMenu(String title, Runnable action) {
        super(new Label(title), action);
        super.setReference(this);
    }
}
