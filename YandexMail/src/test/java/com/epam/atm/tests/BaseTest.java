package com.epam.atm.tests;

import com.epam.atm.utils.Browser;
import com.epam.atm.utils.WebDriverSingleton;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected Browser browser;//WebDriver driver ;

    @BeforeClass
    public void setUp() {
       browser = WebDriverSingleton.getWebDriverInstance();
    }

    @AfterClass
    public void quit() {
        browser.quit();
    }
}
