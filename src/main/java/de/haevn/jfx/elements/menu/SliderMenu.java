package de.haevn.jfx.elements.menu;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.control.Slider;

public class SliderMenu extends AbstractCustomMenuItem<Slider> {
    public SliderMenu(String title, Runnable action) {
        super(new Slider(), action);
    }

    public double getValue() {
        return item.getValue();
    }

    public SliderMenu setValue(double value) {
        item.setValue(value);
        return this;
    }

    public SliderMenu setMin(double min) {
        item.setMin(min);
        return this;
    }

    public SliderMenu setMax(double max) {
        item.setMax(max);
        return this;
    }

    public SliderMenu setMajorTickUnit(double majorTickUnit) {
        item.setMajorTickUnit(majorTickUnit);
        return this;
    }

    public SliderMenu setMinorTickCount(int minorTickCount) {
        item.setMinorTickCount(minorTickCount);
        return this;
    }

    public SliderMenu setBlockIncrement(double blockIncrement) {
        item.setBlockIncrement(blockIncrement);
        return this;
    }

    public SliderMenu setSnapToTicks(boolean snapToTicks) {
        item.setSnapToTicks(snapToTicks);
        return this;
    }

    public SliderMenu setSnapToPixel(boolean snapToPixel) {
        item.setSnapToPixel(snapToPixel);
        return this;
    }

    public double getMin() {
        return item.getMin();
    }

    public double getMax() {
        return item.getMax();
    }

    public ReadOnlyDoubleProperty valueProperty() {
        return item.valueProperty();
    }


}
