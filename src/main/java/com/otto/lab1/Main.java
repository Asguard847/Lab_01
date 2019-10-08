package com.otto.lab1;

import com.otto.lab1.model.NYGift;
import com.otto.lab1.model.UserOutputDisplayModel;
import com.otto.lab1.service.NYGiftFillerService;
import com.otto.lab1.service.UserIOService;
import com.otto.lab1.service.impl.NYGiftFillerServiceImpl;
import com.otto.lab1.service.impl.UserIOServiceImpl;
import javafx.util.Pair;
import org.apache.log4j.Logger;

import java.lang.invoke.MethodHandles;

public class Main {

    private static final Logger LOG = Logger.getLogger(MethodHandles.lookup().lookupClass());

    private NYGiftFillerService nyGiftFillerService = new NYGiftFillerServiceImpl();
    private UserIOService userIOService = new UserIOServiceImpl();

    public static void main(String[] args) {

        LOG.info("Launching program ...");

        Main main = new Main();
        main.run();
    }

    public void run() {

        Pair<Integer, Integer> userInput = userIOService.getUserInput();

        NYGift nyGift = nyGiftFillerService.fillTheGift();

        UserOutputDisplayModel model = userIOService.getUserOutputDisplayModel(nyGift,
                userInput.getKey(), userInput.getValue());

        LOG.info("Displaying output to console");

        System.out.println(model);

    }
}
