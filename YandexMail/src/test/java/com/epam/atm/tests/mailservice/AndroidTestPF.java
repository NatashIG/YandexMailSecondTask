package com.epam.atm.tests.mailservice;

import com.epam.atm.pages.mailservice.androidPF.HomePageAndroid;
import com.epam.atm.pages.mailservice.androidPF.LoginPageAndroid;
import com.epam.atm.pages.mailservice.androidPF.MailBoxAndroid;
import com.epam.atm.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AndroidTestPF extends BaseTest {

    @BeforeMethod
    public void login() {

        HomePageAndroid homePage = new HomePageAndroid(browser);

        LoginPageAndroid loginPage = homePage.open().enterMailBox();
        loginPage.login("stellapolare5922", "wdlearning");
    }

    @Test
    public void findEmail() throws InterruptedException {

        MailBoxAndroid mailbox = new MailBoxAndroid(browser);
        mailbox.searchEmail("struggle");
        mailbox.selectSearchResult();
        Assert.assertTrue(mailbox.emailIsFound(),"Wrong search results");
    }
    @AfterMethod
    public void logOff() {

        MailBoxAndroid mailbox = new MailBoxAndroid(browser);
        mailbox.logoff();
    }
}