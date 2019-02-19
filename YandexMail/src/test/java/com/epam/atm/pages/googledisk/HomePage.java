package com.epam.atm.pages.googledisk;

import com.epam.atm.utils.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends AbstractPage {
    private static final String URL = "https://www.google.com/intl/ru/drive/";

    @FindBy(xpath="//a[contains(@class,'maia-button')]")
    private WebElement enterGoogleDisk;


    public HomePage(Browser browser) {
        super(browser);
    }
    public HomePage open(){
        browser.get(URL);
        return this;
    }
    public LoginPage enterGoogleDisk(){
        browser.jsclick(enterGoogleDisk);
        return new LoginPage(browser);
    }
}
