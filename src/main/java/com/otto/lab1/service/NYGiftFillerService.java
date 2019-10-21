package com.otto.lab1.service;

import com.otto.lab1.model.Chocolate;
import com.otto.lab1.model.NYGift;
import com.otto.lab1.model.Sweet;

/**
 * Class contains method for creating a NY gift.
 */

public interface NYGiftFillerService {

    /**
     * Method creates sweet New Year present for our beloved.
     * Implementation fills our present with {@link Sweet}
     * and {@link Chocolate} instances
     * and determines total weight of our gift in grams.
     * @return - {@link com.otto.lab1.model.NYGift} instance
     */

    NYGift fillTheGift();
}
