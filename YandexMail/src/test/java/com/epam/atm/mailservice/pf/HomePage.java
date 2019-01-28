package com.epam.atm.mailservice.pf;

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
       return this;
    }
    public LoginPage enterMailBox(){
        enterMailbox.click();
        return new LoginPage(driver);
    }
}
