package com.epam.atm.pages.googledisk;

import com.epam.atm.utils.Browser;
import com.epam.atm.utils.CustomActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GDMainPage extends AbstractPage {

    @FindBy(xpath ="//div[contains(@class,'gb_ib')]")
    private WebElement userAvatar;

    @FindBy(xpath = "//div[text()='bee!.jpg']/ancestor::div[@role='gridcell']")
    private WebElement file;

    @FindBy(xpath="//div[@class='a-s-T-j a-da-wf']")
    private WebElement trashBin;

    @FindBy(xpath = "//div[@role='img']")
    private WebElement image;

    @FindBy (xpath = "//div[contains(@class,'a-b-va-d')]")
    private WebElement backButton;

    @FindBy(xpath = "//div[text()='7.jpg']/ancestor::div[@role='gridcell']")
    private WebElement image7;

    @FindBy(xpath = "//div[@role='menu']//div[text()='Удалить']")
    private WebElement contextMenuDelete;

    @FindBy(xpath = "//a[@target='_top']")
    private WebElement logOffButton;


    public GDMainPage(Browser browser) {
        super(browser);
    }
    public boolean isLoggedIn(){
        return userAvatar.isDisplayed();
    }
    public GDMainPage deleteFile(){
        waitForElementVisible(file);
        waitForElementVisible(trashBin);
        CustomActions.dragAndDrop(browser,file,trashBin);
        return this;
    }
    public TrashBinPage openTrashBin(){
        browser.highlightElement(trashBin);
        trashBin.click();
        //browser.unHighlightElement(trashBin);
        return new TrashBinPage(browser);
    }
    public GDMainPage viewFile(){
        waitForElementVisible(file);
        CustomActions.doubleClick(browser,file);
        return this;
    }
    public boolean imageIsOpened(){
        return image.isDisplayed();
    }
    public GDMainPage backToMainPage(){
        backButton.click();
        return this;
    }
    public  GDMainPage deleteFileContextMenu(){
        waitForElementVisible(image7);
        CustomActions.contextClick(browser,image7,contextMenuDelete);
        return this;
    }
    public GDMainPage selectUserAvatar(){
        userAvatar.click();
        return this;
    }
    public HomePage logoff(){
        logOffButton.click();
        return new HomePage(browser);
    }
}