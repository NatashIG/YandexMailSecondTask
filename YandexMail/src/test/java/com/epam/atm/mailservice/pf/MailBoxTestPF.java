package com.epam.atm.mailservice.pf;

import com.epam.atm.mailservice.po.HomePage;
import com.epam.atm.mailservice.po.LoginPage;
import com.epam.atm.mailservice.po.MailBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class MailBoxTestPF {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nataha\\Desktop\\AT_CDP\\WebDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void login() {

        LoginPage loginPage = new HomePage(driver).open().enterMailBox();
        loginPage.fillLoginField("stellapolare5922");
        loginPage.login();
        loginPage.fillPasswordField("wdlearning");
        loginPage.login();

        Assert.assertTrue(driver.findElement(By.className("mail-User-Name")).isDisplayed(), "Login is unsuccessful");
    }

    @Test
    public void createNewEmail() {

        MailBox mailbox = new MailBox(driver);
        mailbox.writeNewEmail();

        EditEmailPage editEmailPage = new EditEmailPage(driver);
        editEmailPage.fillAddresseeField("stella5922@gmail.com");
        editEmailPage.fillSubjectField("Hello Stella!");
        editEmailPage.fillEmailBody("Hello!");

        mailbox.openDraftsFolder();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='mail-MessageSnippet-Content']")).isDisplayed(), "The draft has not been saved");
        mailbox.openEmail();

        Assert.assertTrue(driver.findElement(By.name("to")).getText().contains("stella5922"), "Wrong addressee");
        editEmailPage.sendEmail();
        mailbox.emailSentCheck();

        mailbox.openDraftsFolder();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'ns-view-messages-list')]")).getText().contains("В папке «Черновики» нет писем."), "The letter has not been sent");

        mailbox.openSentFolder();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='mail-MessageSnippet-Content']")).isDisplayed(), "The letter has not been sent");
    }

    @Test
    public void createNewFolder() {

        MailBox mailbox = new MailBox(driver);
        mailbox.createFolder();
        mailbox.fillFolderName("TestFolder");
        mailbox.createFolderFinal();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'ns-view-folders')]")).getText().contains("TestFolder"), "Folder has not been created");
    }

    @Test
    public void findEmail() {

        MailBox mailbox = new MailBox(driver);
        mailbox.fillSearchField("struggle");
        mailbox.selectSearchResult();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='mail-Message-Content']")).getText().contains("struggle"),"Wrong search results");
    }

    @AfterMethod
    public void logOff() {

        MailBox mailbox = new MailBox(driver);
        mailbox.selectUserAvatar();
        mailbox.logoff();
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}