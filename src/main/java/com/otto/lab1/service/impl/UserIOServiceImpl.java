package com.otto.lab1.service.impl;

import com.otto.lab1.model.*;
import com.otto.lab1.service.FindBySugarRangeService;
import com.otto.lab1.service.GiftSortingService;
import com.otto.lab1.service.UserIOService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Service
public class UserIOServiceImpl implements UserIOService {

    @Autowired
    GiftSortingService sortingService;
    @Autowired
    FindBySugarRangeService sugarRangeService;

    @Override
    public Pair<Integer, Integer> getUserInput() {

        System.out.println("\t\t\t\t\t********************");
        System.out.println("\n\t\t\tWe welcome you in our NY gift service!");
        System.out.println("\n\t\t\t\t\t********************");

        System.out.println("\nPlease, enter min and max values of sugar level(in percent) acceptable for you");

        try (Scanner scanner = new Scanner(System.in)) {
            int min = scanner.nextInt();
            int max = scanner.nextInt();
            if (min > max) {
                throw new RuntimeException("Incorrect Input! Please, enter minimal value first.");
            }
            Pair<Integer, Integer> results = new Pair<>(min, max);
            return results;
        } catch (InputMismatchException e) {
            throw new RuntimeException("Incorrect Input! Please, enter min and max numbers like: \"12 24\"");
        }
    }

    @Override
    public UserOutputDisplayModel getUserOutputDisplayModel(NYGift nyGift, double min, double max) {

        UserOutputDisplayModel model = new UserOutputDisplayModel();
        List<Sweetness> sweetnesses = nyGift.getGiftContents();

        model.setTotalWeightInGr(nyGift.getTotalWeightInGr());

        setSweetnesses(model, sweetnesses);

        List<Sweetness> sortedSweetnesses = sortingService.
                sortByWeightAscendingOrder(sweetnesses);

        model.setHeaviest(sortedSweetnesses.get(sortedSweetnesses.size() - 1));

        model.setLightest(sortedSweetnesses.get(0));

        sortedSweetnesses = sortingService.sortBySugarPercentAscendingOrder(sweetnesses);

        model.setMostSweetest(sortedSweetnesses.get(sortedSweetnesses.size() - 1));

        model.setLessSweetest(sortedSweetnesses.get(0));


        model.setOneFromSugarRange(sugarRangeService.findSweetnessBySugarRange(min, max, sweetnesses));

        model.setSetFromSugarRange(sugarRangeService.findAllSweetnessBySugarRange(min, max, sweetnesses));

        return model;
    }

    private void setSweetnesses(UserOutputDisplayModel model, List<Sweetness> sweetnesses) {

        model.setCandyChupaChups(sweetnesses.stream().filter(sweetness -> sweetness.getName().
                equals(CandyTypes.CHUPACHUPS.getCandyName())).count());

        model.setCandyRoshen(sweetnesses.stream().filter(sweetness -> sweetness.getName().
                equals(CandyTypes.ROSHEN.getCandyName())).count());

        model.setSweetKorovka(sweetnesses.stream().filter(sweetness -> sweetness.getName().
                equals(SweetTypes.KOROVKA.getSweetName())).count());

        model.setSweetRafaello(sweetnesses.stream().filter(sweetness -> sweetness.getName().
                equals(SweetTypes.RAFAELLO.getSweetName())).count());

        model.setSweetRomashka(sweetnesses.stream().filter(sweetness -> sweetness.getName().
                equals(SweetTypes.ROMASHKA.getSweetName())).count());

        model.setSweetShokolapki(sweetnesses.stream().filter(sweetness -> sweetness.getName().
                equals(SweetTypes.SHOKOLAPKI.getSweetName())).count());

        model.setChocolateAlyonka(sweetnesses.stream().filter(sweetness -> sweetness.getName().
                equals(ChocolateTypes.ALYONKA.getChocolateName())).count());

        model.setChocolateMars(sweetnesses.stream().filter(sweetness -> sweetness.getName().
                equals(ChocolateTypes.MARS.getChocolateName())).count());

        model.setChocolateSnickers(sweetnesses.stream().filter(sweetness -> sweetness.getName().
                equals(ChocolateTypes.SNICKERS.getChocolateName())).count());
    }
}
