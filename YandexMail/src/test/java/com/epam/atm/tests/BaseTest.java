package com.epam.atm.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nataha\\Desktop\\AT_CDP\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        /*To run tests on Firefox node use the code below instead of new ChromeDriver():
         *System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nataha\\Desktop\\AT_CDP\\WebDriver\\geckodriver.exe");
         *driver = new FirefoxDriver();
         * try {
         *    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
         *   driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), capabilities);
         *} catch (MalformedURLException e) {
         *    e.printStackTrace();
         *}*/
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}
