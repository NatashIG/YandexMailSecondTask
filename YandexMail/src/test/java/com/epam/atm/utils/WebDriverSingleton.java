package com.epam.atm.utils;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {

    private static Browser browser;

    private WebDriverSingleton() {
    }

    public static Browser getWebDriverInstance() {
        if (browser == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nataha\\Desktop\\AT_CDP\\WebDriver\\chromedriver.exe");
            browser = new Browser(new ChromeDriver());
            browser.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            browser.manage().window().maximize();
        }
        return browser;
    }
}

/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nataha\\Desktop\\AT_CDP\\WebDriver\\chromedriver.exe");
 *DesiredCapabilities capabilities = DesiredCapabilities.chrome();
 *driver = new ChromeDriver(capabilities);
 *driver = new CustomDriverDecorator(driver); - acc.to lecture
 */

