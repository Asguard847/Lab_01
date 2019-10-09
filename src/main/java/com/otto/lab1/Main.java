package com.otto.lab1;

import com.otto.lab1.model.NYGift;
import com.otto.lab1.model.UserOutputDisplayModel;
import com.otto.lab1.service.NYGiftFillerService;
import com.otto.lab1.service.UserIOService;
import javafx.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.invoke.MethodHandles;


@SpringBootApplication
public class Main implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    NYGiftFillerService nyGiftFillerService ;
    @Autowired
    UserIOService userIOService;

    public static void main(String[] args) {
        LOG.info("Starting application");
        SpringApplication.run(Main.class, args);
        LOG.info("Finishing application");
    }

    @Override
    public void run(String... args) {

        Pair<Integer, Integer> userInput = userIOService.getUserInput();

        NYGift nyGift = nyGiftFillerService.fillTheGift();

        UserOutputDisplayModel model = userIOService.getUserOutputDisplayModel(nyGift,
                userInput.getKey(), userInput.getValue());

        System.out.println(model);

    }
}
