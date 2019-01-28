package com.epam.atm.mailservice.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {

    private static final By LOGIN_FIELD_LOCATOR = By.name("login");
    private static final By PASSWORD_FIELD_LOCATOR = By.id("passp-field-passwd");
    private static final By LOGIN_BUTTON_LOCATOR = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public LoginPage fillLoginField(String login){
       if (driver.findElement(LOGIN_FIELD_LOCATOR).isDisplayed()){
           driver.findElement(LOGIN_FIELD_LOCATOR).sendKeys(login);
       }
        return this;
    }
    public LoginPage fillPasswordField(String password){
        driver.findElement(PASSWORD_FIELD_LOCATOR).sendKeys(password);
        return this;
    }
    public MailBox login() {
        driver.findElement(LOGIN_BUTTON_LOCATOR).click();
        return new MailBox(driver);
    }
}




