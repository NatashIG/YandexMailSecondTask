package com.epam.atm.pages.mailservice.androidPF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPageAndroid extends MailBoxAndroid {

    @FindBy(xpath = "//div[@class='messageBody-content']")
    private WebElement emailContent;

    public EmailPageAndroid(WebDriver driver) {
        super(driver);
    }
}