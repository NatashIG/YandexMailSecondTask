package com.epam.atm.mailservice.pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(name="login")
    private WebElement loginField;

    @FindBy(id="passp-field-passwd")
    private WebElement passwordField;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage fillLoginField(String login){
       if (loginField.isDisplayed()){
           loginField.sendKeys(login);
       }
        return this;
    }
    public LoginPage fillPasswordField(String password){
        passwordField.sendKeys(password);
        return this;
    }
    public MailBox login() {
        loginButton.click();
        return new MailBox(driver);
    }
}




