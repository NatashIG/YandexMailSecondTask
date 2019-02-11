package com.epam.atm.pages.mailservice.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailPage extends MailBox {
    public static final By EMAIL_CONTENT_LOCATOR = By.xpath("//div[@class='mail-Message-Content']");

    public EmailPage(WebDriver driver) {
        super(driver);
    }
}
