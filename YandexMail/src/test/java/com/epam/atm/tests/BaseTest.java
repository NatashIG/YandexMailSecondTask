package com.epam.atm.tests;

import com.epam.atm.utils.Browser;
import com.epam.atm.utils.WebDriverSingleton;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

public class BaseTest {

    protected Browser browser;//WebDriver driver ;

    @BeforeClass
    public void setUp() throws MalformedURLException {
       browser = WebDriverSingleton.getWebDriverInstance();
    }

    @AfterClass
    public void quit() {
        browser.quit();
    }
}
