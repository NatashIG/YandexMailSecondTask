package com.epam.atm.googledisk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends AbstractPage {
    private static final String URL = "https://www.google.com/intl/ru/drive/";

    @FindBy(xpath="//a[contains(@class,'maia-button')]")
    private WebElement enterGoogleDisk;


    public HomePage(WebDriver driver) {
        super(driver);
    }
    public HomePage open(){
        driver.get(URL);
        return this;
    }
    public LoginPage enterGoogleDisk(){
        jsclick(enterGoogleDisk);
        return new LoginPage(driver);
    }
}
