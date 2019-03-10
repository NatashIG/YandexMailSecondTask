package com.epam.atm.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CustomActions {

    public static void dragAndDrop(WebDriver driver, WebElement element, WebElement target) {
        new Actions(driver).dragAndDrop(element,target).build().perform();
    }

    public static void doubleClick(WebDriver driver,WebElement element) {
        new Actions(driver).doubleClick(element).build().perform();
    }

    public static void contextClick(WebDriver driver,WebElement element,WebElement menuItem) {
        new Actions(driver).contextClick(element).click(menuItem).build().perform();
    }

    public static void scrollToElement(WebDriver driver,WebElement element){
        new Actions(driver).moveToElement(element).build().perform();
    }
}

