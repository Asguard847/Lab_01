package com.otto.lab1.factory;

import com.otto.lab1.model.*;

/**
 * Factory class contains methods for getting different types
 * of {@link com.otto.lab1.model.Sweetness}
 */

public interface SweetnessFactory {

    /**
     * Method returns instance of {@link com.otto.lab1.model.Candy}.
     * Properties of this instance depend on input candy type.
     *
     * @param type - Enum type of the candy.
     * @return - instance of {@link com.otto.lab1.model.Candy}.
     */
    Candy getCandy(CandyTypes type);

    /**
     * Method returns instance of {@link com.otto.lab1.model.Sweet}.
     * Properties of this sweet depend on input sweet type.
     *
     * @param type - Enum type of the sweet.
     * @return - instance of {@link com.otto.lab1.model.Sweet}.
     */

    Sweet getSweet(SweetTypes type);

    /**
     * Method returns instance of {@link com.otto.lab1.model.Chocolate}.
     * Properties of this chocolate depend on input chocolate type.
     *
     * @param type - Enum type of the chocolate.
     * @return - instance of {@link com.otto.lab1.model.Chocolate}.
     */

    Chocolate getChocolate(ChocolateTypes type);

}
