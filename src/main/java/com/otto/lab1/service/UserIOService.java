package com.otto.lab1.service;

import com.otto.lab1.model.NYGift;
import com.otto.lab1.model.UserOutputDisplayModel;
import javafx.util.Pair;

public interface UserIOService {

    Pair<Integer, Integer> getUserInput();

    UserOutputDisplayModel getUserOutputDisplayModel(NYGift nyGift, double min, double max);

}
