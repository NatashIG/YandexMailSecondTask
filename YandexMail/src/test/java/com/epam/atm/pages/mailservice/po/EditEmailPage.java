package com.epam.atm.pages.mailservice.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditEmailPage extends MailBox {
    public static final By ADDRESSEE_LOCATOR = By.name("to");
    public static final By SUBJECT_LOCATOR = By.xpath("//input[contains(@class,'mail-Compose-Field-Input-Controller')]");
    public static final By EMAIL_BODY_LOCATOR = By.xpath("//div[@id='cke_1_contents']/textarea");
    public static final By SAVED_DRAFT_LOCATOR = By.xpath("//span[@data-key='view=compose-autosave-status']");
    public static final By SEND_BUTTON_LOCATOR = By.xpath("//button[@type='submit']");

    public EditEmailPage(WebDriver driver) {
        super(driver);
    }
    public EditEmailPage fillAddresseeField(String addressee){
        driver.findElement(ADDRESSEE_LOCATOR).sendKeys(addressee);
        return this;
    }
    public EditEmailPage fillSubjectField(String subject){
        driver.findElement(SUBJECT_LOCATOR).sendKeys(subject);
        return this;
    }
    public EditEmailPage fillEmailBody(String body){
        driver.findElement(EMAIL_BODY_LOCATOR).sendKeys(body);
        waitForElementVisible(SAVED_DRAFT_LOCATOR);
        return this;
    }
    public EditEmailPage createEmail(String addressee, String subject, String body){
        fillAddresseeField(addressee);
        fillSubjectField(subject);
        fillEmailBody(body);
        return this;
    }
    public MailBox sendEmail() {
        driver.findElement(SEND_BUTTON_LOCATOR).click();
        return new MailBox(driver);
    }
}
