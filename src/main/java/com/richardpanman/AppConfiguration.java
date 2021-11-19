package com.richardpanman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.lang.String;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

public class AppConfiguration {
    private Configuration cfg;
    private HashMap<String, Object> inputMap = new HashMap<String, Object>();

    public AppConfiguration(File templateDirectoryPath) throws Exception {
        cfg = new Configuration();
        if (!templateDirectoryPath.exists() || !templateDirectoryPath.isDirectory()) {
            throw new FileNotFoundException(String.format(
                    "The given directory name [%s] either doesn't exist or isn't a directory", templateDirectoryPath));
        }
        cfg.setDirectoryForTemplateLoading(templateDirectoryPath);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }

    public void AddInput(String variable, Object value) {
        inputMap.put(variable, value);
    }
}