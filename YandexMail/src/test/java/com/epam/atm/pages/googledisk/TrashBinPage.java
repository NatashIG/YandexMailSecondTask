package com.epam.atm.pages.googledisk;

import com.epam.atm.utils.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrashBinPage extends AbstractPage {

    @FindBy(xpath = "//div[text()='Корзина']")
    private WebElement trashBinOpened;

    @FindBy(xpath = "//div[@data-target='doc']")
    private WebElement deletedFile;


    public TrashBinPage(Browser browser) {
        super(browser);
    }
    public boolean isOpened() {
        waitForElementVisible(trashBinOpened);
        return trashBinOpened.isDisplayed();
    }
    public boolean fileIsPresent() {
        return deletedFile.isDisplayed();
    }
}