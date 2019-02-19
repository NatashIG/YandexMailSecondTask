package com.epam.atm.pages.googledisk;

import com.epam.atm.utils.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
    protected Browser browser; //WebDriver driver;
    private static final int WAIT_FOR_ELEMENT_TIMEOUT_SECONDS = 10;

    public AbstractPage(Browser browser) { //Browser browser
        this.browser = browser;//driver = driver;
        PageFactory.initElements(browser,this); //driver
    }
    protected void waitForElementVisible(WebElement element) {
        new WebDriverWait(browser, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(element));
    }
}
