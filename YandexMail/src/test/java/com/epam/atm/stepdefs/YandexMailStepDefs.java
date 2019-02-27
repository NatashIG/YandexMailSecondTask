package com.epam.atm.stepdefs;

import com.epam.atm.pages.mailservice.pf.EditEmailPage;
import com.epam.atm.pages.mailservice.pf.HomePage;
import com.epam.atm.pages.mailservice.pf.LoginPage;
import com.epam.atm.pages.mailservice.pf.MailBox;
import com.epam.atm.utils.Browser;
import com.epam.atm.utils.WebDriverSingleton;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class YandexMailStepDefs {
    
    Browser browser;

    @Given("I am logged into yandex mail")
    public void login() {
        browser = WebDriverSingleton.getWebDriverInstance();
        HomePage homePage = new HomePage(browser);
        LoginPage loginPage = homePage.open().enterMailBox();
        loginPage.login("stellapolare5922", "wdlearning");
    }

    @When("^I send a new email$")
    public void iSendANewEmail(){
        browser = WebDriverSingleton.getWebDriverInstance();
        MailBox mailbox = new MailBox(browser);
        mailbox.writeNewEmail();

        EditEmailPage editEmailPage = new EditEmailPage(browser);
        editEmailPage.createEmail("stella5922@gmail.com","Hello Stella!","Hello!");

        editEmailPage.sendEmail();
        mailbox.emailSentCheck();
    }

    @Then("^I should see the new email in 'Sent' folder$")
    public void iShouldSeeTheNewEmailInSentFolder() {
        browser = WebDriverSingleton.getWebDriverInstance();
        MailBox mailbox = new MailBox(browser);
        mailbox.openSentFolder();
        Assert.assertTrue(mailbox.emailIsSent(), "The letter has not been sent");;
    }

    @When("^I create a new folder (\\w+)$")
    public void isCreateANewFolder(String folderName) {
        browser = WebDriverSingleton.getWebDriverInstance();
        MailBox mailbox = new MailBox(browser);
        mailbox.createFolder();
        mailbox.fillFolderName(folderName);
        mailbox.createFolderFinal();
    }

    @Then("^I should see a new folder in the list of folders$")
    public void iShouldSeeANewFolderInTheListOfFolders(){
        browser = WebDriverSingleton.getWebDriverInstance();
        MailBox mailbox = new MailBox(browser);
        Assert.assertTrue(mailbox.newFolderisPresent(), "Folder has not been created");;
    }

   @When("^I find the email by keyword (\\w+)$")
    public void iFindTheEmailByKeywordKeyword(String keyword) throws InterruptedException  {
       browser = WebDriverSingleton.getWebDriverInstance();
        MailBox mailbox = new MailBox(browser);
        mailbox.fillSearchField(keyword);
        mailbox.selectSearchResult();
    }

    @Then("^I should see this email is opened$")
    public void iShouldSeeThisEmailIsOpened(){
        browser = WebDriverSingleton.getWebDriverInstance();
        MailBox mailbox = new MailBox(browser);
        Assert.assertTrue(mailbox.emailIsFound(),"Wrong search results");;
    }


}