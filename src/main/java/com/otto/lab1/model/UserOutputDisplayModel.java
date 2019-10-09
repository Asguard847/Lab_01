package com.otto.lab1.model;

import java.util.List;
import java.util.Set;

public class UserOutputDisplayModel {

    private long totalWeightInGr;

    private long candyChupaChups;
    private long candyRoshen;
    private long sweetKorovka;
    private long sweetRafaello;
    private long sweetRomashka;
    private long sweetShokolapki;
    private long chocolateAlyonka;
    private long chocolateMars;
    private long chocolateSnickers;

    private Sweetness heaviest;
    private Sweetness lightest;

    private Sweetness mostSweetest;
    private Sweetness lessSweetest;

    private Sweetness oneFromSugarRange;
    private Set<Sweetness> setFromSugarRange;

    public long getTotalWeightInGr() {
        return totalWeightInGr;
    }

    public void setTotalWeightInGr(long totalWeightInGr) {
        this.totalWeightInGr = totalWeightInGr;
    }

    public long getCandyChupaChups() {
        return candyChupaChups;
    }

    public void setCandyChupaChups(long candyChupaChups) {
        this.candyChupaChups = candyChupaChups;
    }

    public long getCandyRoshen() {
        return candyRoshen;
    }

    public void setCandyRoshen(long candyRoshen) {
        this.candyRoshen = candyRoshen;
    }

    public long getSweetKorovka() {
        return sweetKorovka;
    }

    public void setSweetKorovka(long sweetKorovka) {
        this.sweetKorovka = sweetKorovka;
    }

    public long getSweetRafaello() {
        return sweetRafaello;
    }

    public void setSweetRafaello(long sweetRafaello) {
        this.sweetRafaello = sweetRafaello;
    }

    public long getSweetRomashka() {
        return sweetRomashka;
    }

    public void setSweetRomashka(long sweetRomashka) {
        this.sweetRomashka = sweetRomashka;
    }

    public long getSweetShokolapki() {
        return sweetShokolapki;
    }

    public void setSweetShokolapki(long sweetShokolapki) {
        this.sweetShokolapki = sweetShokolapki;
    }

    public long getChocolateAlyonka() {
        return chocolateAlyonka;
    }

    public void setChocolateAlyonka(long chocolateAlyonka) {
        this.chocolateAlyonka = chocolateAlyonka;
    }

    public long getChocolateMars() {
        return chocolateMars;
    }

    public void setChocolateMars(long chocolateMars) {
        this.chocolateMars = chocolateMars;
    }

    public long getChocolateSnickers() {
        return chocolateSnickers;
    }

    public void setChocolateSnickers(long chocolateSnickers) {
        this.chocolateSnickers = chocolateSnickers;
    }

    public Sweetness getHeaviest() {
        return heaviest;
    }

    public void setHeaviest(Sweetness heaviest) {
        this.heaviest = heaviest;
    }

    public Sweetness getLightest() {
        return lightest;
    }

    public void setLightest(Sweetness lightest) {
        this.lightest = lightest;
    }

    public Sweetness getMostSweetest() {
        return mostSweetest;
    }

    public void setMostSweetest(Sweetness mostSweetest) {
        this.mostSweetest = mostSweetest;
    }

    public Sweetness getLessSweetest() {
        return lessSweetest;
    }

    public void setLessSweetest(Sweetness lessSweetest) {
        this.lessSweetest = lessSweetest;
    }

    public Sweetness getOneFromSugarRange() {
        return oneFromSugarRange;
    }

    public void setOneFromSugarRange(Sweetness oneFromSugarRange) {
        this.oneFromSugarRange = oneFromSugarRange;
    }

    public Set<Sweetness> getSetFromSugarRange() {
        return setFromSugarRange;
    }

    public void setSetFromSugarRange(Set<Sweetness> setFromSugarRange) {
        this.setFromSugarRange = setFromSugarRange;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("\nThank you! Your New Year gift was composed. Here is the contents:");
        sb.append("\nCandies:");
        sb.append("\n\tChupaChups: " + candyChupaChups);
        sb.append("\n\tRoshen: " + candyRoshen);
        sb.append("\nSweets:");
        sb.append("\n\tKorovka: " + sweetKorovka);
        sb.append("\n\tRafaello: " + sweetRafaello);
        sb.append("\n\tRomashka: " + sweetRomashka);
        sb.append("\n\tShokolapki: " + sweetShokolapki);
        sb.append("\nChocolates:");
        sb.append("\n\tAlyonka: " + chocolateAlyonka);
        sb.append("\n\tMars: " + chocolateMars);
        sb.append("\n\tSnickers: " + chocolateSnickers);
        sb.append("\n\nTotal weight: " + totalWeightInGr + " gram");
        sb.append("\n\n\t\t\t\t\t********************");
        sb.append("\n\nYour gift was sorted by weight and sugar percent! Here are the results:");
        sb.append("\nThe heaviest piece: " + heaviest.getName() + " - " + heaviest.getWeightInGr() + "gr");
        sb.append("\nThe lightest piece: " + lightest.getName() + " - " + lightest.getWeightInGr() + "gr");
        sb.append("\nThe sweetest piece: " + mostSweetest.getName() + " - " + mostSweetest.getSugarPerCent() + "% sugar");
        sb.append("\nThe least sweet piece: " + lessSweetest.getName() + " - " + lessSweetest.getSugarPerCent() + "% sugar");
        sb.append("\n\n\t\t\t\t\t********************");

        if (oneFromSugarRange == null || setFromSugarRange.isEmpty()) {
            sb.append("\nUnfortunately, there is nothing in our gift that matches your");
            sb.append("\nsugar range requirements.");
        } else {
            sb.append("\n\nYour sugar range requirements are considered. If you are looking");
            sb.append("\nfor one piece you can choose " + oneFromSugarRange.getName());
            sb.append(". It's sugar percent is " + oneFromSugarRange.getSugarPerCent());
            sb.append(".\nOr you can choose from the list, all elements are in acceptable range: ");
            sb.append("\n");

            setFromSugarRange.stream().forEach(sweetness -> sb.append("\n\t" + sweetness.getName() +
                    " - " + sweetness.getSugarPerCent() + "% sugar"));
        }

        sb.append("\n\n\t\t\t\t\t********************");
        sb.append("\n\n\t\t\tThat's all. Thanks for being with us!");

        return sb.toString();
    }
}
