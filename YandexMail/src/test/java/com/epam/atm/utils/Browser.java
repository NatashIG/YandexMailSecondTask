package com.epam.atm.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.List;
import java.util.Set;

public class Browser implements WebDriver {

    protected WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
    }

    public void get(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public WebElement findElement(By by) {
        Reporter.log(String.format("Finding element: %s, current URL: '%s'", by.toString(), driver.getCurrentUrl()), true);
        return driver.findElement(by);
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public void close() {
        driver.close();
    }

    public void quit() {
        driver.quit();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    public Navigation navigate() {
        return driver.navigate();
    }

    public Options manage() {
        return driver.manage();
    }

    public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
    }

    public void unHighlightElement(WebElement element) {
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
    }

    public void jsclick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }
}

