package com.epam.atm.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxDriverCreator implements WebDriverCreator {
    private WebDriver driver;

    public WebDriver createWebDriver() {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nataha\\Desktop\\AT_CDP\\WebDriver\\geckodriver.exe");
        try {
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new FirefoxDriver();
    }
}
//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nataha\\Desktop\\AT_CDP\\WebDriver\\geckodriver.exe");
//        return new FirefoxDriver(); -- to run locally (not remotely) use only this two lines