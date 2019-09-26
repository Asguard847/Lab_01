package com.otto.lab1.service.impl;

import com.otto.lab1.model.Sweetness;
import com.otto.lab1.service.FindBySugarRangeService;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class FindByShugarRangeServiceImpl implements FindBySugarRangeService {


    @Override
    public Sweetness findSweetnessBySugarRange(double min, double max,
                                               List<Sweetness> giftContents) {

        Sweetness result = giftContents.stream().filter(sweetness ->
                sweetness.getSugarPerCent() >= min && sweetness.getSugarPerCent() <= max).
                findAny().orElse(null);
        return result;
    }


    @Override
    public Set<Sweetness> findAllSweetnessBySugarRange(double min, double max, List<Sweetness> giftContents) {

        List<Sweetness> resultsList = giftContents.stream().filter(sweetness ->
                sweetness.getSugarPerCent() >= min && sweetness.getSugarPerCent() <= max).
                collect(Collectors.toList());

        Comparator<Sweetness> byNameComparator = Comparator.comparing(Sweetness::getName);
        Set<Sweetness> resultsSet = new TreeSet<>(byNameComparator);
        resultsSet.addAll(resultsList);
        return resultsSet;
    }
}
