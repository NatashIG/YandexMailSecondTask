package com.epam.atm.pages.mailservice.pf;

import com.epam.atm.reporting.MyLogger;
import org.openqa.selenium.By;
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
    public MailBox login(String login, String password) {
        fillLoginField(login);
        loginButton.click();
        fillPasswordField(password);
        loginButton.click();
        MyLogger.log("Logged in");
        return new MailBox(driver);
    }
    public boolean isLoggedIn(){
        return driver.findElement(By.className("mail-User-Name")).isDisplayed();
    }
}




