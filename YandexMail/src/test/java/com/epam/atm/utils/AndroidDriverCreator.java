package com.epam.atm.utils;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverCreator implements WebDriverCreator {
    public WebDriver createWebDriver(){
        System.setProperty("ANDROID_HOME", "C:\\Users\\Nataha\\AppData\\Local\\Android\\Sdk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator_5554");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");//APP,"C:\\Users\\Nataha\\Desktop\\AT_CDP\\12. AT of Mobile Apps\\ApiDemos-debug.apk");
        capabilities.setCapability("chromedriverExecutable","C:\\Users\\Nataha\\Desktop\\AT_CDP\\WebDriver\\chromedriver.exe");

        try {
            return new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
//AndroidDriver<WebElement>