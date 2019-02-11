package com.epam.atm.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSexecutor {

    public static void highlightElement(WebDriver driver,WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
    }
    public static void unHighlightElement(WebDriver driver,WebElement element) {
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
    }
    public static void jsclick (WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }
}
