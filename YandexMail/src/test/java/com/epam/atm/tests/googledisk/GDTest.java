package com.epam.atm.tests.googledisk;

import com.epam.atm.bo.googledisk.User;
import com.epam.atm.pages.googledisk.GDMainPage;
import com.epam.atm.pages.googledisk.HomePage;
import com.epam.atm.pages.googledisk.LoginPage;
import com.epam.atm.pages.googledisk.TrashBinPage;
import com.epam.atm.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GDTest extends BaseTest {

    @BeforeMethod
    public void login() {

        HomePage homePage = new HomePage(browser);

        LoginPage loginPage = homePage.open().enterGoogleDisk();
        loginPage.login(new User("natalie.ignatovich@gmail.com", "wdlearning"));

        GDMainPage gdMainPage = new GDMainPage(browser);
        Assert.assertTrue(gdMainPage.isLoggedIn(), "Login is unsuccessful");
    }

    @Test
    public void doubleClick() {

        GDMainPage gdMainPage = new GDMainPage(browser);
        gdMainPage.viewFile();
        Assert.assertTrue(gdMainPage.imageIsOpened(), "Image is not opened");
        gdMainPage.backToMainPage();
        Assert.assertTrue(gdMainPage.isLoggedIn(), "It is not main page");
    }

    @Test
    public void dragNDrop() {

        GDMainPage gdMainPage = new GDMainPage(browser);
        gdMainPage.deleteFile();

        TrashBinPage trashBinPage = new TrashBinPage(browser);
        gdMainPage.openTrashBin();
        Assert.assertTrue(trashBinPage.isOpened(), "TrashBin has not been opened");
        Assert.assertTrue(trashBinPage.fileIsPresent(), "TrashBin is empty");
    }

    @Test
    public void contextClick() {

        GDMainPage gdMainPage = new GDMainPage(browser);
        gdMainPage.deleteFileContextMenu();

        TrashBinPage trashBinPage = new TrashBinPage(browser);
        gdMainPage.openTrashBin();
        Assert.assertTrue(trashBinPage.isOpened(), "TrashBin has not been opened");
        Assert.assertTrue(trashBinPage.fileIsPresent(), "TrashBin is empty");
    }

    @AfterMethod
    public void logOff() {

        GDMainPage gdMainPage = new GDMainPage(browser);
        gdMainPage.selectUserAvatar();
        gdMainPage.logoff();
    }
}
