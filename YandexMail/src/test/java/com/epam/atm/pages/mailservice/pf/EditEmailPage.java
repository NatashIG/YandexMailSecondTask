package com.epam.atm.pages.mailservice.pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditEmailPage extends MailBox {

    @FindBy(name="to")
    private WebElement emailAddressee;

    @FindBy(xpath="//input[contains(@class,'mail-Compose-Field-Input-Controller')]")
    private WebElement emailSubject;

    @FindBy(xpath="//div[@id='cke_1_contents']/textarea")
    private WebElement emailBody;

    @FindBy(xpath="//span[@data-key='view=compose-autosave-status']")
    private WebElement savedDraft;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement sendButton;

    @FindBy(xpath="//div[contains(@class,'mail-Done')]")
    private WebElement emailSentConfirmationLocator;


    public EditEmailPage(WebDriver driver) {
        super(driver);
    }

    public EditEmailPage fillAddresseeField(String addressee){
        emailAddressee.sendKeys(addressee);
        return this;
    }
    public EditEmailPage fillSubjectField(String subject){
        emailSubject.sendKeys(subject);
        return this;
    }
    public EditEmailPage fillEmailBody(String body){
        emailBody.sendKeys(body);
        waitForElementVisible(savedDraft);
        return this;
    }
    public EditEmailPage createEmail(String addressee, String subject, String body){
        fillAddresseeField(addressee);
        fillSubjectField(subject);
        fillEmailBody(body);
        return this;
    }
    public MailBox sendEmail() {
        sendButton.click();
        return new MailBox(driver);
    }
}
