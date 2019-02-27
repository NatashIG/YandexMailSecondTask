package com.epam.atm.pages.mailservice.pf;

import org.openqa.selenium.By;
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
    public boolean draftIsPresent(){
        return driver.findElement(By.xpath("//div[@class='mail-MessageSnippet-Content']")).isDisplayed();
    }
    public EditEmailPage openEmail() {
        email.click();
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
        emailSentConfirmation.isDisplayed();
        return this;
    }
    public boolean draftsFolderIsEmpty(){
        return driver.findElement(By.xpath("//div[contains(@class,'ns-view-messages-list')]")).getText().contains("В папке «Черновики» нет писем.");
    }
    public MailBox openSentFolder(){
        sentFolder.click();
        return this;
    }
    public boolean emailIsSent(){
        return driver.findElement(By.xpath("//div[@class='mail-MessageSnippet-Content']")).isDisplayed();
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
        waitForElementVisible(newFolder);
        return this;
    }
    public boolean newFolderisPresent(){
       return driver.findElement(By.xpath("//div[contains(@class,'ns-view-folders')]")).getText().contains("TestFolder");
    }
    public MailBox fillSearchField(String keyword) throws InterruptedException {
        Thread.sleep(500);
        waitForElementVisible(searchField).click();
        searchField.sendKeys(keyword);
        return this;
    }
    public EmailPage selectSearchResult(){
        searchResults.click();
        return new EmailPage(driver);
    }
    public boolean emailIsFound(){
        return driver.findElement(By.xpath("//div[@class='mail-Message-Content']")).getText().contains("struggle");
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
