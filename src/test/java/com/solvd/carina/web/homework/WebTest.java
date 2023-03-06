package com.solvd.carina.web.homework;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.gui.homeworkPages.HomePage;
import com.solvd.carina.demo.gui.homeworkPages.LoginBlockedPage;
import com.solvd.carina.demo.gui.homeworkPages.LoginPage;
import com.solvd.carina.demo.utils.UserEnum;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testLoginStandardUser() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened!");
        loginPage.fillInputs(UserEnum.STANDARD);
        HomePage homePage = loginPage.clickLoginSuccess();
        Assert.assertTrue(homePage.isPageOpened(), "Credentials aren't Correct");
        Assert.assertTrue(homePage.areResourcesLoaded());
    }

    @Test
    public void testLoginLockedOutUser() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.assertPageOpened();
        loginPage.fillInputs(UserEnum.LOCKED_OUT);
        LoginBlockedPage page = loginPage.clickLoginBlocked();
        page.assertPageOpened();
    }

    @Test
    public void testLoginProblemUser() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.assertPageOpened();
        loginPage.fillInputs(UserEnum.PROBLEM);
        HomePage page = loginPage.clickLoginSuccess();
        Assert.assertFalse(page.areResourcesLoaded());
    }

    @Test
    public void testPictureLinkClick() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened!");
        loginPage.fillInputs(UserEnum.STANDARD);
        HomePage page = loginPage.clickLoginSuccess();
        page.clickImage(2);
    }

    @Test
    public void testAddToCartButton() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened!");
        loginPage.fillInputs(UserEnum.STANDARD);
        HomePage page = loginPage.clickLoginSuccess();
        page.clickAddToCart(4);
    }

    @Test
    public void clickCart() { // this will be improved to another complex test
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened!");
        loginPage.fillInputs(UserEnum.STANDARD);
        HomePage page = loginPage.clickLoginSuccess();
        page.clickCart();
    }
}
