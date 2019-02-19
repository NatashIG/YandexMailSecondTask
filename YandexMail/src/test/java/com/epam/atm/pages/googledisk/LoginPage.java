package com.epam.atm.pages.googledisk;

import com.epam.atm.bo.googledisk.User;
import com.epam.atm.utils.Browser;
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


    public LoginPage(Browser browser) {
        super(browser);
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
    public GDMainPage login(User user) {
        fillLoginField(user.getLogin());
        fillPasswordField(user.getPassword());
        passwordNextButton.click();
        return new GDMainPage(browser);
    }
}
