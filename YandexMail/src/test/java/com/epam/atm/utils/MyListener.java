package com.epam.atm.utils;

import com.epam.atm.reporting.MyLogger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;

public class MyListener extends TestListenerAdapter {


    @Override
    public void onTestFailure(ITestResult tr) {
        MyLogger.error("Failed");
        takeScreenshot();
    }

    @Override
    public void onConfigurationFailure(ITestResult itr) {
        MyLogger.error("Make screenshot on Configuration Failure");
        takeScreenshot();
//      byte[] screenshot = ((TakesScreenshot) WebDriverSingleton.getWebDriverInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
//      saveScreenshot(screenshot);
    }

    public void takeScreenshot() {
        final String SCREENSHOTS_NAME_TPL = "target\\screenshots\\screenshot";
        File screenshot = ((TakesScreenshot) WebDriverSingleton.getWebDriverInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotName = SCREENSHOTS_NAME_TPL + System.nanoTime();
            File copy = new File(screenshotName + ".png");
            FileUtils.copyFile(screenshot, copy);
            MyLogger.info("Saved screenshot: " + screenshotName);
        } catch (IOException e) {
            MyLogger.error("Failed to make screenshot");
        }
    }
}
//    @Attachment(value = "Page Screeenshot", type="image/png")
//    public byte[] saveScreenshot(byte[] screenShot){
//        //byte[] screenShot = ((TakesScreenshot) WebDriverSingleton.getWebDriverInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
//        return screenShot;
//    }
