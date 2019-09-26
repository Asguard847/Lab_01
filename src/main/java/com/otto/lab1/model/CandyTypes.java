package com.otto.lab1.model;

public enum CandyTypes {

    CHUPACHUPS("ChupaChups", 30, 97.8d, true),
    ROSHEN("Roshen", 6, 95.8d, false);

    private String candyName;
    private int weightInGr;
    private double sugarPercent;
    private boolean hasStick;

    CandyTypes(String candyName, int weightInGr, double sugarPercent, boolean hasStick) {
        this.candyName = candyName;
        this.weightInGr = weightInGr;
        this.sugarPercent = sugarPercent;
        this.hasStick = hasStick;
    }

    public String getCandyName() {
        return candyName;
    }

    public int getWeightInGr() {
        return weightInGr;
    }

    public double getSugarPercent() {
        return sugarPercent;
    }

    public boolean isHasStick() {
        return hasStick;
    }
}
