package com.epam.atm.pages.mailservice.pf;

import com.epam.atm.reporting.MyLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    private static final String URL = "https://yandex.by/";

    @FindBy(xpath="//a[contains(@class,'button desk-notif-card')]")
    private WebElement enterMailbox;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open(){
       driver.get(URL);
        MyLogger.warn("Something went wrong");
       return this;
    }
    public LoginPage enterMailBox(){
        enterMailbox.click();
        return new LoginPage(driver);
    }
}
