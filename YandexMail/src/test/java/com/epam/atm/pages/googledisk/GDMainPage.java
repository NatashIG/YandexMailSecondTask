package com.epam.atm.pages.googledisk;

import com.epam.atm.utils.CustomActions;
import com.epam.atm.utils.JSexecutor;
import org.openqa.selenium.WebDriver;
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


    public GDMainPage(WebDriver driver) {
        super(driver);
    }
    public boolean isLoggedIn(){
        return userAvatar.isDisplayed();
    }
    public GDMainPage deleteFile(){
        waitForElementVisible(file);
        waitForElementVisible(trashBin);
        CustomActions.dragAndDrop(driver,file,trashBin);
        return this;
    }
    public TrashBinPage openTrashBin(){
        JSexecutor.highlightElement(driver,trashBin);
        trashBin.click();
        //JSexecutor.unHighlightElement(driver, trashBin);
        return new TrashBinPage(driver);
    }
    public GDMainPage viewFile(){
        waitForElementVisible(file);
        CustomActions.doubleClick(driver,file);
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
        CustomActions.contextClick(driver,image7,contextMenuDelete);
        return this;
    }
    public GDMainPage selectUserAvatar(){
        userAvatar.click();
        return this;
    }
    public HomePage logoff(){
        logOffButton.click();
        return new HomePage(driver);
    }
}