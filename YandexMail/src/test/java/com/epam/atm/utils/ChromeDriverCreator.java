package com.epam.atm.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverCreator implements WebDriverCreator{
    public WebDriver createWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nataha\\Desktop\\AT_CDP\\WebDriver\\chromedriver.exe");
        return new ChromeDriver();
    }
}
