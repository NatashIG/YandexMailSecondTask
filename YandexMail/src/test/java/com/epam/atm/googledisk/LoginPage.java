package com.epam.atm.googledisk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(name = "identifier")
    private WebElement loginField;

    @FindBy(id = "identifierNext")
    private WebElement loginNextButton;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(id = "passwordNext")
    private WebElement passwordNextButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage fillLoginField(String login) {
        if (loginField.isDisplayed()) {
            loginField.sendKeys(login);
            loginNextButton.click();
        }
        return this;
    }

    public LoginPage fillPasswordField(String password) {
        passwordField.sendKeys(password);
        return this;
    }
    public GDMainPage login(String login, String password) {
        fillLoginField(login);
        fillPasswordField(password);
        passwordNextButton.click();
        return new GDMainPage(driver);
    }
}
