package com.epam.atm.pages.mailservice.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

    private static final String URL = "https://yandex.by/";
    private static final By ENTER_MAILBOX_LOCATOR = By.xpath("//a[contains(@class,'button desk-notif-card')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public HomePage open(){
       driver.get(URL);
       return this;
    }
    public LoginPage enterMailBox(){
        driver.findElement(ENTER_MAILBOX_LOCATOR).click();
        return new LoginPage(driver);
    }
}
