package com.itm.utils;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String captureScreenshot(
            WebDriver driver,
            String testName,
            String result) {

        File source =
                ((TakesScreenshot)driver)
                .getScreenshotAs(
                        OutputType.FILE);

        String filePath =
                "screenshots/"
                + testName
                + "_"
                + result
                + ".png";

        try {

            FileUtils.copyFile(
                    source,
                    new File(filePath));

        } catch(IOException e) {

            e.printStackTrace();
        }

        return filePath;
    }
}
