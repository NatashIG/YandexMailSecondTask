package com.epam.atm.pages.mailservice.androidPF;

import com.epam.atm.pages.mailservice.pf.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailBoxAndroid extends AbstractPage {

    @FindBy(xpath="//div[contains(@class,'Tappable-inactive head-item head-item_right2')]")//input[@class='textinput__control']")
    private WebElement searchIcon;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@class='Tappable-inactive search-button']")
    private WebElement searchButton;

    @FindBy(xpath="//div[@class='ptr-scrollable messagesScroller']")
    private WebElement searchResults;

    @FindBy(xpath = "//span[text()='Назад']")
    private WebElement backLink;

    @FindBy(xpath = "//div[contains(@class,'Tappable-inactive head-item head-item_left')]")
    private WebElement backIcon;

    @FindBy(xpath = "//div[contains(@class,'Tappable-inactive head-item head-item_left')]")
    private WebElement burgerMenu;

    @FindBy(xpath ="//a[contains(@href,'https://passport.yandex.by')]" )//"//span[text()='Выйти']")
    private WebElement logOffLink;


    public MailBoxAndroid(WebDriver driver) {
        super(driver);
    }
    public MailBoxAndroid searchEmail (String keyword){
        searchIcon.click();
        searchField.click();
        searchField.sendKeys(keyword);
        searchButton.click();
        return this;
    }
    public EmailPageAndroid selectSearchResult(){
        searchResults.click();
        return new EmailPageAndroid(driver);
    }
    public boolean emailIsFound(){
        return driver.findElement(By.xpath("//div[@class='messageBody-content']")).getText().contains("struggle");
    }
    public HomePageAndroid logoff() {
        backLink.click();
        backIcon.click();
        burgerMenu.click();
        logOffLink.click();
        return new HomePageAndroid(driver);
    }
}
