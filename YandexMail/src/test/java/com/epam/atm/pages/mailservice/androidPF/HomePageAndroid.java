package com.epam.atm.pages.mailservice.androidPF;

import com.epam.atm.pages.mailservice.pf.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageAndroid extends AbstractPage {

    private static final String URL = "https://yandex.by/";

    @FindBy(xpath = "//a[contains(@class,'mheader3__user-login')]")
    private WebElement enterMailbox;

    public HomePageAndroid(WebDriver driver) {
       super(driver);
    }
    public HomePageAndroid open(){
        driver.get(URL);
        return this;
    }
    public LoginPageAndroid enterMailBox(){
        enterMailbox.click();
        return new LoginPageAndroid(driver);
    }
}