package com.erp.automation.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {
    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        screenshotName = screenshotName.replaceAll("[^a-zA-Z0-9]", "_");

        String screenshotDir = System.getProperty("user.dir") + "/test-output/screenshots/";
        File destDir = new File(screenshotDir);
        if (!destDir.exists()) {
            destDir.mkdirs();
        }

        String screenshotPath = screenshotDir + screenshotName + "_" + timestamp + ".png";
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(screenshotPath);

        try {
            FileHandler.copy(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }
}
