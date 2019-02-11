package com.epam.atm.pages.mailservice.pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends MailBox {

    @FindBy(xpath="//div[@class='mail-Message-Content']")
    private WebElement emailContent;

    public EmailPage(WebDriver driver) {
        super(driver);
    }
}
