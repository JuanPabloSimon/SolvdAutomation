package com.solvd.carina.web.homework;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.gui.homeworkPages.*;
import com.solvd.carina.demo.utils.UserEnum;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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
    public void testLoginProblemUser() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.assertPageOpened();
        loginPage.fillInputs(UserEnum.PROBLEM);
        HomePage page = loginPage.clickLoginSuccess();
        Assert.assertFalse(page.areResourcesLoaded());
    }

    @Test(dataProvider = "DPN°1")
    public void testPictureLinkClick(String TUID, int a) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened!");
        loginPage.fillInputs(UserEnum.STANDARD);
        HomePage page = loginPage.clickLoginSuccess();
        page.clickImage(a);
    }

    @Test(dataProvider = "DPN°1")
    public void testAddToCartButton(String TUID, int a) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened!");
        loginPage.fillInputs(UserEnum.STANDARD);
        HomePage page = loginPage.clickLoginSuccess();
        page.clickAddToCart(a);
        Assert.assertTrue(page.getNavBar().productWasAdded());
    }

    @DataProvider(parallel = false, name = "DPN°1")
    public static Object[][] dataProvider() {
        return new Object[][]{
                {"TUID: Data_1", 0},
                {"TUID: Data_2", 1},
                {"TUID: Data_3", 2},
                {"TUID: Data_4", 3},
                {"TUID: Data_5", 4},
                {"TUID: Data_6", 5}
        };
    }

    @Test
    public void testPurchase() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened!");
        loginPage.fillInputs(UserEnum.STANDARD);
        HomePage page = loginPage.clickLoginSuccess();
        page.clickAddToCart(2);
        synchronized (page) {
            try {
                page.wait(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        CartPage cartPage = page.clickCart();
        synchronized (cartPage) {
            try {
                cartPage.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        CheckOutPage checkOutPage = cartPage.clickCheckOut();
        synchronized (checkOutPage) {
            try {
                checkOutPage.wait(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        checkOutPage.fillInputs();
        CheckOut2Page checkOut2Page = checkOutPage.clickContinue();
        synchronized (checkOut2Page) {
            try {
                checkOut2Page.wait(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        CheckOutCompletePage completePage = checkOut2Page.clickFinish();
        completePage.assertPageOpened();
        synchronized (completePage) {
            try {
                completePage.wait(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
