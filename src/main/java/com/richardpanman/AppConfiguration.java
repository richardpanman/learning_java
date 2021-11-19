package com.richardpanman;

import java.io.File;
import java.util.HashMap;
import java.lang.String;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.StringWriter;
import java.io.IOException;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class AppConfiguration {
    private final static Logger LOGGER = Logger.getLogger(AppConfiguration.class.getName());
    private Configuration cfg;
    private HashMap<String, Object> inputMap = new HashMap<String, Object>();

    public AppConfiguration(File templateDirectoryPath) throws Exception {
        LOGGER.log(Level.FINE, "AppConfiguration called");
        cfg = new Configuration();
        cfg.setDirectoryForTemplateLoading(templateDirectoryPath);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }

    public void setInput(String variable, Object value) {
        inputMap.put(variable, value);
    }

    public HashMap<String, Object> getInput() {
        return inputMap;
    }

    public String render(String templateFileString) throws Exception {
        StringWriter outputWriter = new StringWriter();
        try {
            Template temp = cfg.getTemplate(templateFileString);
            temp.process(inputMap, outputWriter);
        } catch (IOException | TemplateException e) {
            LOGGER.log(Level.SEVERE, e.toString());
            throw e;
        }
        return outputWriter.toString();
    }
}