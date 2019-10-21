package com.otto.lab1.service;

import com.otto.lab1.model.Sweetness;

import java.util.List;
import java.util.Set;

/**
 * Class contains methods for retrieving one or all
 * sweetness matching required range of sugar percent
 */

public interface FindBySugarRangeService {

    /**
     * Method filters contents of the New Year gift {@link com.otto.lab1.model.NYGift}
     * by sugar percentage and returns one random {@link com.otto.lab1.model.Sweetness}.
     * If nothing matches our requirements returns null.
     *
     * @param min          - Minimal sugar percent acceptable.
     * @param max          - Maximal sugar percent acceptable.
     * @param giftContents - Contents of our gift.
     * @return - Random {@link com.otto.lab1.model.Sweetness} instance which satisfies
     * min and max sugar percent parameters, null if nothing matches.
     */

    Sweetness findSweetnessBySugarRange(double min, double max, List<Sweetness> giftContents);

    /**
     * Method filters contents of the New Year gift {@link com.otto.lab1.model.NYGift}
     * by sugar percentage and returns one random {@link com.otto.lab1.model.Sweetness}.
     *
     * @param min          - Minimal sugar percent acceptable.
     * @param max          - Maximal sugar percent acceptable.
     * @param giftContents - Contents of our gift.
     * @return - Set of {@link com.otto.lab1.model.Sweetness} that match min and max
     * sugar percentage requirements.
     */

    Set<Sweetness> findAllSweetnessBySugarRange(double min, double max, List<Sweetness> giftContents);
}
