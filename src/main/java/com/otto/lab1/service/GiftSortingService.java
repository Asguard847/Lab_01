package com.otto.lab1.service;

import com.otto.lab1.model.Sweetness;

import java.util.List;

/**
 * Class contains methods for sorting
 * our sweet New Year gift {@link com.otto.lab1.model.NYGift} contents
 * by both weight and shugar percent parameters.
 */

public interface GiftSortingService {

    /**
     * Method sorts NYGift contents by weight in ascending order.
     *
     * @param giftContents - List of sweetness to be sorted.
     * @return - Sorted list.
     */

    List<Sweetness> sortByWeightAscendingOrder(List<Sweetness> giftContents);

    /**
     * Method sorts NYGift contents by weight in descending order.
     *
     * @param giftContents - List of sweetness to be sorted.
     * @return - Sorted list.
     */

    List<Sweetness> sortByWeightDescendingOrder(List<Sweetness> giftContents);

    /**
     * Method sorts NYGift contents by sugar percent in ascending order.
     *
     * @param giftContents - List of sweetness to be sorted.
     * @return - Sorted list.
     */

    List<Sweetness> sortBySugarPercentAscendingOrder(List<Sweetness> giftContents);

    /**
     * Method sorts NYGift contents by sugar percent in descending order.
     *
     * @param giftContents - List of sweetness to be sorted.
     * @return - Sorted list.
     */

    List<Sweetness> sortBySugarPercentDescendingOrder(List<Sweetness> giftContents);


}
