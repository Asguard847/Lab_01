package com.otto.lab1.model;

public enum SweetTypes {
    KOROVKA("Korovka", 15, 81.8d, false),
    RAFAELLO("Rafaello", 10, 36.8d, false),
    ROMASHKA("Romashka", 15, 70.61d, true),
    SHOKOLAPKI("Shokolapki", 6, 61.3d, true);

    private String sweetName;
    private int weightInGr;
    private double sugarPercent;
    private boolean isChocolate;

    SweetTypes(String sweetName, int weightInGr, double sugarPercent, boolean isChocolate) {
        this.sweetName = sweetName;
        this.weightInGr = weightInGr;
        this.sugarPercent = sugarPercent;
        this.isChocolate = isChocolate;
    }

    public String getSweetName() {
        return sweetName;
    }

    public int getWeightInGr() {
        return weightInGr;
    }

    public double getSugarPercent() {
        return sugarPercent;
    }

    public boolean isChocolate() {
        return isChocolate;
    }
}
