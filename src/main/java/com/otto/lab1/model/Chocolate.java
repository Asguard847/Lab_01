package com.otto.lab1.model;

public class Chocolate extends Sweetness {

    private double cocoaPercent;
    private boolean hasFiller;

    public double getCocoaPercent() {
        return cocoaPercent;
    }

    public void setCocoaPercent(double cocoaPercent) {
        this.cocoaPercent = cocoaPercent;
    }

    public boolean isHasFiller() {
        return hasFiller;
    }

    public void setHasFiller(boolean hasFiller) {
        this.hasFiller = hasFiller;
    }
}
