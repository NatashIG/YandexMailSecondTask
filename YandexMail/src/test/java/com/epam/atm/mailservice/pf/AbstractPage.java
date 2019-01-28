package com.epam.atm.mailservice.pf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

    protected WebDriver driver;
    private static final int WAIT_FOR_ELEMENT_TIMEOUT_SECONDS = 15;


    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitForElementVisible(By locator) { // нужно правильно прописать
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions. visibilityOfAllElementsLocatedBy(locator));//тоже
    }
}