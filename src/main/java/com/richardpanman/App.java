package com.richardpanman;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private final static Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        File templateDirectoryPath = new File("src/main/resources/templates/");
        try {
            new AppConfiguration(templateDirectoryPath);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString());
        }
    }
}
