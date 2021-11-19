package com.richardpanman;

import org.junit.Test;
import java.util.HashMap;
import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class AppConfigurationTest {
    @Test
    public void validTemplateDirectory() {
        File templateDirectoryPath = new File("src/test/resources/templates/");
        try {
            new AppConfiguration(templateDirectoryPath);
        } catch (Exception e) {
            fail("Exception raised but none expected");
        }
    }

    @Test
    public void invalidTemplateDirectory() {
        File templateDirectoryPath = new File("invalid_path_to_directory!!!!");
        try {
            new AppConfiguration(templateDirectoryPath);
            fail("Exception was not raised but one was expected");
        } catch (Exception e) {
            return;
        }
    }

    @Test
    public void setAndGetInput() {
        HashMap<String, Object> expectedResult = new HashMap<String, Object>();
        expectedResult.put("Test key", "Test value");
        File templateDirectoryPath = new File("src/test/resources/templates/");
        try {
            AppConfiguration appCfg = new AppConfiguration(templateDirectoryPath);
            appCfg.addInput("Test key", "Test value");
            assertEquals(expectedResult, appCfg.getInput());
        } catch (Exception e) {
            fail("Exception raised but none expected");
        }
    }
}
