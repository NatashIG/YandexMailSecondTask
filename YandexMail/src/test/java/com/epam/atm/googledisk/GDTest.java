package com.epam.atm.googledisk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class GDTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nataha\\Desktop\\AT_CDP\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        /*To run tests on Firefox node use the code below instead of new ChromeDriver():
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nataha\\Desktop\\AT_CDP\\WebDriver\\geckodriver.exe");
        try {
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }*/
    }
    @BeforeMethod
    public void login() {

        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = homePage.open().enterGoogleDisk();
        loginPage.login("natalie.ignatovich@gmail.com", "wdlearning");

        GDMainPage gdMainPage = new GDMainPage(driver);
        Assert.assertTrue(gdMainPage.isLoggedIn(), "Login is unsuccessful");
    }
    @Test
    public void doubleClick(){

        GDMainPage gdMainPage = new GDMainPage(driver);
        gdMainPage.viewFile();
        Assert.assertTrue(gdMainPage.imageIsOpened(),"Image is not opened");
        gdMainPage.backToMainPage();
        Assert.assertTrue(gdMainPage.isLoggedIn(), "Login is unsuccessful");
    }
    @Test
    public void dragNDrop(){

        GDMainPage gdMainPage = new GDMainPage(driver);
        gdMainPage.deleteFile();

        TrashBinPage trashBinPage = new TrashBinPage(driver);
        gdMainPage.openTrashBin();
        Assert.assertTrue(trashBinPage.isOpened(), "TrashBin has not been opened");
        Assert.assertTrue(trashBinPage.fileIsPresent(), "TrashBin is empty");
    }
    @Test
    public void contextClick(){

        GDMainPage gdMainPage = new GDMainPage(driver);
        gdMainPage.deleteFileContextMenu();

        TrashBinPage trashBinPage = new TrashBinPage(driver);
        gdMainPage.openTrashBin();
        Assert.assertTrue(trashBinPage.isOpened(), "TrashBin has not been opened");
        Assert.assertTrue(trashBinPage.fileIsPresent(), "TrashBin is empty");
    }
    @AfterMethod
    public void logOff() {

        GDMainPage gdMainPage = new GDMainPage(driver);
        gdMainPage.selectUserAvatar();
        gdMainPage.logoff();
    }
    @AfterClass
    public void quit() {
        driver.quit();
    }
}
