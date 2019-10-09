package com.otto.lab1.service.impl;

import com.otto.lab1.model.Sweetness;
import com.otto.lab1.service.GiftSortingService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class GiftSortingServiceImpl implements GiftSortingService {

    @Override
    public List<Sweetness> sortByWeightAscendingOrder(List<Sweetness> giftContents) {

        Collections.sort(giftContents, getComparatorByWeight());
        return giftContents;

    }

    @Override
    public List<Sweetness> sortByWeightDescendingOrder(List<Sweetness> giftContents) {

        Collections.sort(giftContents, getComparatorByWeightReversed());
        return giftContents;

    }

    @Override
    public List<Sweetness> sortBySugarPercentAscendingOrder(List<Sweetness> giftContents) {

        Collections.sort(giftContents, getComparatorBySugarPercent());
        return giftContents;

    }

    @Override
    public List<Sweetness> sortBySugarPercentDescendingOrder(List<Sweetness> giftContents) {

        Collections.sort(giftContents, getComparatorBySugarPercentReversed());
        return giftContents;

    }

    private Comparator<Sweetness> getComparatorByWeight() {

        return Comparator.comparing(Sweetness::getWeightInGr);

    }


    private Comparator<Sweetness> getComparatorByWeightReversed() {

        return getComparatorByWeight().reversed();

    }

    private Comparator<Sweetness> getComparatorBySugarPercent() {

        return Comparator.comparing(Sweetness::getSugarPerCent);

    }

    private Comparator<Sweetness> getComparatorBySugarPercentReversed() {

        return getComparatorBySugarPercent().reversed();

    }
}
