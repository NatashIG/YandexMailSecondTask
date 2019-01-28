package com.epam.atm.mailservice.pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailBox extends AbstractPage {

    @FindBy(className="mail-User-Name")
    private WebElement userName;

    @FindBy(xpath="//span[contains(@class,'mail-ComposeButton-Text')]")
    private WebElement writeLetterButton;

    @FindBy(xpath="//a[@href='#draft']")
    private WebElement draftsFolder;

    @FindBy(xpath="//div[contains(@class,'mail-Done')]")
    private WebElement emailSentConfirmation;

    @FindBy(xpath="//a[@href='#sent']")
    private WebElement sentFolder;

    @FindBy(xpath="//div[contains(@class,'ns-view-messages-list')]")
    private WebElement emptyFolderState;

    @FindBy(xpath="//div[@class='mail-MessageSnippet-Content']")
    private WebElement email;

    @FindBy(xpath="//span[contains(@class,'mail-NestedList-Setup-Add')]")
    private WebElement createFolderButtom;

    @FindBy(xpath="//input[@name='folder_name']")
    private WebElement folderNameField;

    @FindBy(xpath="//button[@data-dialog-action='dialog.submit']")
    private WebElement popUpCreateFolderButton;

    @FindBy(xpath="//a[@title='TestFolder']")
    private WebElement newFolder;

    @FindBy(xpath="//div[contains(@class,'ns-view-folders')]")
    private WebElement foldersList;

    @FindBy(xpath="//input[@class='textinput__control']")
    private WebElement searchField;

    @FindBy(xpath="//div[@class='mail-SuggestItem']")
    private WebElement searchResults;

    @FindBy(xpath="//span[contains(@class,'mail-User-Avatar')]")
    private WebElement userAvatar;

    @FindBy(xpath="//a[@data-metric='Выйти из сервисов Яндекса']")
    private WebElement logOffButton;

    public MailBox(WebDriver driver) {
        super(driver);
    }

    public EditEmailPage writeNewEmail(){
        writeLetterButton.click();
        return new EditEmailPage(driver);
    }
    public MailBox openDraftsFolder(){
        draftsFolder.click();
        return this;
    }
    public EditEmailPage openEmail() {
        email.click();
        return new EditEmailPage(driver);
    }
    public MailBox emailSentCheck(){
        emailSentConfirmation.isDisplayed();
        return this;
    }
    public MailBox openSentFolder(){
        sentFolder.click();
        return this;
    }
    public MailBox createFolder(){
        createFolderButtom.click();
        return this;
    }
    public MailBox fillFolderName(String folderName){
        folderNameField.sendKeys(folderName);
        return this;
    }
    public MailBox createFolderFinal(){
        popUpCreateFolderButton.click();
       // waitForElementVisible(NEW_FOLDER_LOCATOR);    разобраться с вэйтами
        return this;
    }
    public MailBox fillSearchField(String keyword){
        searchField.sendKeys(keyword);
        return this;
    }
    public EmailPage selectSearchResult(){
        searchResults.click();
        return new EmailPage(driver);
    }
    public MailBox selectUserAvatar(){
        userAvatar.click();
        return this;
    }
    public HomePage logoff(){
        logOffButton.click();
        return new HomePage(driver);
    }
}
