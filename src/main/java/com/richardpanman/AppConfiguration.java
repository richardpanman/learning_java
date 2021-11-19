package com.richardpanman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.lang.String;
import java.util.logging.Level;
import java.util.logging.Logger;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

public class AppConfiguration {
    private final static Logger LOGGER = Logger.getLogger(AppConfiguration.class.getName());
    private Configuration cfg;
    private HashMap<String, Object> inputMap = new HashMap<String, Object>();

    public AppConfiguration(File templateDirectoryPath) throws Exception {
        LOGGER.log(Level.FINE, "AppConfiguration called");
        this.cfg = new Configuration();
        if (!templateDirectoryPath.exists() || !templateDirectoryPath.isDirectory()) {
            String exceptionString = String.format(
                    "The given directory name [%s] either doesn't exist or isn't a directory", templateDirectoryPath);
            LOGGER.log(Level.SEVERE, exceptionString);
            throw new FileNotFoundException(exceptionString);
        }
        this.cfg.setDirectoryForTemplateLoading(templateDirectoryPath);
        this.cfg.setDefaultEncoding("UTF-8");
        this.cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }

    public void addInput(String variable, Object value) {
        this.inputMap.put(variable, value);
    }

    public HashMap<String, Object> getInput() {
        return this.inputMap;
    }
}