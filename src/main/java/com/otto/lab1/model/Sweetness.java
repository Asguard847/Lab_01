package com.otto.lab1.model;

public abstract class Sweetness {

    protected String name;
    protected int weightInGr;
    protected double sugarPerCent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeightInGr() {
        return weightInGr;
    }

    public void setWeightInGr(int weightInGr) {
        this.weightInGr = weightInGr;
    }

    public double getSugarPerCent() {
        return sugarPerCent;
    }

    public void setSugarPerCent(double sugarPerCent) {
        this.sugarPerCent = sugarPerCent;
    }
}
