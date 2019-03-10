package com.epam.atm.pages.mailservice.androidPF;

import com.epam.atm.pages.mailservice.pf.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageAndroid extends AbstractPage {

    @FindBy(id="passp-field-login")
    private WebElement loginField;

    @FindBy(id="passp-field-passwd")
    private WebElement passwordField;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement loginButton;

    public LoginPageAndroid(WebDriver driver) {
        super(driver);
    }
    public LoginPageAndroid fillLoginField(String login){
        loginField.sendKeys(login);
        return this;
    }
    public LoginPageAndroid fillPasswordField(String password){
        passwordField.sendKeys(password);
        return this;
    }
    public MailBoxAndroid login(String login, String password) {
        fillLoginField(login);
        loginButton.click();
        fillPasswordField(password);
        loginButton.click();
        return new MailBoxAndroid(driver);
    }
}

