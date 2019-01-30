package com.epam.atm.mailservice.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class MailBoxTestPO {
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

        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = homePage.open().enterMailBox();
        loginPage.login("stellapolare5922","wdlearning");

        Assert.assertTrue(loginPage.isLoggedIn(), "Login is unsuccessful");
    }

    @Test
    public void createNewEmail() {

        MailBox mailbox = new MailBox(driver);
        mailbox.writeNewEmail();

        EditEmailPage editEmailPage = new EditEmailPage(driver);
        editEmailPage.createEmail("stella5922@gmail.com","Hello Stella!","Hello!");

        mailbox.openDraftsFolder();
        Assert.assertTrue(mailbox.draftIsPresent(), "The draft has not been saved");
        mailbox.openEmail();

        Assert.assertTrue(mailbox.addresseeMatches(), "Wrong addressee");
        Assert.assertTrue(mailbox.subjectMatches(), "Wrong subject");
        //Assert.assertTrue(mailbox.bodyMatches(), "Wrong body");

        editEmailPage.sendEmail();
        mailbox.emailSentCheck();

        mailbox.openDraftsFolder();
        Assert.assertTrue(mailbox.draftsFolderIsEmpty(), "The letter has not been sent");

        mailbox.openSentFolder();
        Assert.assertTrue(mailbox.emailIsSent(), "The letter has not been sent");
    }

    @Test
    public void createNewFolder() {

        MailBox mailbox = new MailBox(driver);
        mailbox.createFolder();
        mailbox.fillFolderName("TestFolder");
        mailbox.createFolderFinal();
        Assert.assertTrue(mailbox.newFolderisPresent(), "Folder has not been created");
    }

    @Test
    public void findEmail() {

        MailBox mailbox = new MailBox(driver);
        mailbox.fillSearchField("struggle");
        mailbox.selectSearchResult();
        Assert.assertTrue(mailbox.emailIsFound(),"Wrong search results");
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