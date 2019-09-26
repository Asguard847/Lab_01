package com.otto.lab1.model;

public enum ChocolateTypes {
    ALYONKA("Alyonka", 100, 54d, 34.9d, false),
    MARS("Mars", 50, 68d, 26d, true),
    SNICKERS("Snickers", 57, 55.5d, 27d, true);

    private String chocolateName;
    private int weightInGr;
    private double sugarPercent;
    private double cocoaPercent;
    private boolean hasFiller;

    ChocolateTypes(String chocolateName, int weightInGr,
                   double sugarPercent, double cocoaPercent, boolean hasFiller) {
        this.chocolateName = chocolateName;
        this.weightInGr = weightInGr;
        this.sugarPercent = sugarPercent;
        this.cocoaPercent = cocoaPercent;
        this.hasFiller = hasFiller;
    }

    public String getChocolateName() {
        return chocolateName;
    }

    public int getWeightInGr() {
        return weightInGr;
    }

    public double getSugarPercent() {
        return sugarPercent;
    }

    public double getCocoaPercent() {
        return cocoaPercent;
    }

    public boolean isHasFiller() {
        return hasFiller;
    }
}
