package com.epam.atm.tests.mailservice;

import com.epam.atm.pages.mailservice.pf.EditEmailPage;
import com.epam.atm.pages.mailservice.pf.HomePage;
import com.epam.atm.pages.mailservice.pf.LoginPage;
import com.epam.atm.pages.mailservice.pf.MailBox;
import com.epam.atm.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MailBoxTestPF extends BaseTest {

    @BeforeMethod
    public void login() {

        HomePage homePage = new HomePage(browser);

        LoginPage loginPage = homePage.open().enterMailBox();
        loginPage.login("stellapolare5922","wdlearning");

        Assert.assertTrue(loginPage.isLoggedIn(), "Login is unsuccessful");
    }

    @Test
    public void createNewEmail() {

        MailBox mailbox = new MailBox(browser);
        mailbox.writeNewEmail();

        EditEmailPage editEmailPage = new EditEmailPage(browser);
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

        MailBox mailbox = new MailBox(browser);
        mailbox.createFolder();
        mailbox.fillFolderName("TestFolder");
        mailbox.createFolderFinal();
        Assert.assertTrue(mailbox.newFolderisPresent(), "Folder has not been created");
    }

    @Test
    public void findEmail() throws InterruptedException {

        MailBox mailbox = new MailBox(browser);
        mailbox.fillSearchField("struggle");
        mailbox.selectSearchResult();
        Assert.assertTrue(mailbox.emailIsFound(),"Wrong search results");
    }

    @AfterMethod
    public void logOff() {

        MailBox mailbox = new MailBox(browser);
        mailbox.selectUserAvatar();
        mailbox.logoff();
    }
}