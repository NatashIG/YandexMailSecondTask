package com.epam.atm.mailservice.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailBox extends AbstractPage {

    public static final By WRITE_LETTER_BUTTON_LOCATOR = By.xpath("//span[contains(@class,'mail-ComposeButton-Text')]");
    public static final By DRAFTS_FOLDER_LOCATOR = By.xpath("//a[@href='#draft']");
    public static final By EMAIL_SENT_CONFIRMATION_LOCATOR = By.xpath("//div[contains(@class,'mail-Done')]");
    public static final By SENT_FOLDER_LOCATOR = By.xpath("//a[@href='#sent']");
    public static final By EMAIL_LOCATOR = By.xpath("//div[@class='mail-MessageSnippet-Content']");
    public static final By CREATE_FOLDER_BUTTON_LOCATOR = By.xpath("//span[contains(@class,'mail-NestedList-Setup-Add')]");
    public static final By FOLDER_NAME_FIELD = By.xpath("//input[@name='folder_name']");
    public static final By POPUP_CREATE_FOLDER_BUTTON = By.xpath("//button[@data-dialog-action='dialog.submit']");
    public static final By NEW_FOLDER_LOCATOR = By.xpath("//a[@title='TestFolder']");
    public static final By SEARCH_FIELD_LOCATOR = By.xpath("//input[@class='textinput__control']");
    public static final By SEARCH_RESULTS_LOCATOR = By.xpath("//div[@class='mail-SuggestItem']");
    public static final By USER_AVATAR_LOCATOR = By.xpath("//span[contains(@class,'mail-User-Avatar')]");
    public static final By LOGOFF_BUTTON_LOCATOR = By.xpath("//a[@data-metric='Выйти из сервисов Яндекса']");

    public MailBox(WebDriver driver) {
        super(driver);
    }

    public EditEmailPage writeNewEmail(){
        driver.findElement(WRITE_LETTER_BUTTON_LOCATOR).click();
        return new EditEmailPage(driver);
    }
    public MailBox openDraftsFolder(){
        driver.findElement(DRAFTS_FOLDER_LOCATOR).click();
        return this;
    }
    public boolean draftIsPresent(){
        return driver.findElement(By.xpath("//div[@class='mail-MessageSnippet-Content']")).isDisplayed();
    }
    public EditEmailPage openEmail() {
        driver.findElement(EMAIL_LOCATOR).click();
        return new EditEmailPage(driver);
    }
    public boolean addresseeMatches(){
        return driver.findElement(By.name("to")).getText().contains("stella5922");
    }
    public boolean subjectMatches(){
        return driver.findElement(By.xpath("//input[contains(@class,'mail-Compose-Field-Input-Controller')]")).getAttribute("value").contains("Hello Stella!");
    }
    public boolean bodyMatches(){
        return driver.findElement(By.xpath("//div[@id='cke_50_contents']/textarea")).getText().contains("Hello!");
    }
    public MailBox emailSentCheck(){
        driver.findElement(EMAIL_SENT_CONFIRMATION_LOCATOR).isDisplayed();
        return this;
    }
    public boolean draftsFolderIsEmpty(){
        return driver.findElement(By.xpath("//div[contains(@class,'ns-view-messages-list')]")).getText().contains("В папке «Черновики» нет писем.");
    }
    public MailBox openSentFolder(){
        driver.findElement(SENT_FOLDER_LOCATOR).click();
        return this;
    }
    public boolean emailIsSent(){
        return driver.findElement(By.xpath("//div[@class='mail-MessageSnippet-Content']")).isDisplayed();
    }
    public MailBox createFolder(){
        driver.findElement(CREATE_FOLDER_BUTTON_LOCATOR).click();
        return this;
    }
    public MailBox fillFolderName(String folderName){
        driver.findElement(FOLDER_NAME_FIELD).sendKeys(folderName);
        return this;
    }
    public MailBox createFolderFinal(){
        driver.findElement(POPUP_CREATE_FOLDER_BUTTON).click();
        waitForElementVisible(NEW_FOLDER_LOCATOR);
        return this;
    }
    public boolean newFolderisPresent(){
        return driver.findElement(By.xpath("//div[contains(@class,'ns-view-folders')]")).getText().contains("TestFolder");
    }
    public MailBox fillSearchField(String keyword){
        driver.findElement(SEARCH_FIELD_LOCATOR).sendKeys(keyword);
        return this;
    }
    public EmailPage selectSearchResult(){
        driver.findElement(SEARCH_RESULTS_LOCATOR).click();
        return new EmailPage(driver);
    }
    public boolean emailIsFound(){
        return driver.findElement(By.xpath("//div[@class='mail-Message-Content']")).getText().contains("struggle");
    }
    public MailBox selectUserAvatar(){
        driver.findElement(USER_AVATAR_LOCATOR).click();
        return this;
    }
    public HomePage logoff(){
        driver.findElement(LOGOFF_BUTTON_LOCATOR).click();
        return new HomePage(driver);
    }
}
