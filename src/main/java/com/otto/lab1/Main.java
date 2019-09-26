package com.otto.lab1;

import com.otto.lab1.model.NYGift;
import com.otto.lab1.model.UserOutputDisplayModel;
import com.otto.lab1.service.NYGiftFillerService;
import com.otto.lab1.service.UserIOService;
import com.otto.lab1.service.impl.NYGiftFillerServiceImpl;
import com.otto.lab1.service.impl.UserIOServiceImpl;
import javafx.util.Pair;

public class Main {

    private NYGiftFillerService nyGiftFillerService = new NYGiftFillerServiceImpl();
    private UserIOService userIOService = new UserIOServiceImpl();

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {

        Pair<Integer, Integer> userInput = userIOService.getUserInput();

        NYGift nyGift = nyGiftFillerService.fillTheGift();

        UserOutputDisplayModel model = userIOService.getUserOutputDisplayModel(nyGift,
                userInput.getKey(), userInput.getValue());

        System.out.println(model);

    }
}
