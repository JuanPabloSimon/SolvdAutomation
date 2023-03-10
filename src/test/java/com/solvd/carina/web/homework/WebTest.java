package com.solvd.carina.web.homework;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.gui.homework.pages.*;
import com.solvd.carina.demo.service.LoginService;
import com.solvd.carina.demo.utils.DataProvider;
import com.solvd.carina.demo.utils.UserEnum;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class WebTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testLoginStandardUser() {
        HomePage homePage = LoginService.loginPage(getDriver(), UserEnum.STANDARD);
        Assert.assertTrue(homePage.isPageOpened(), "Credentials aren't Correct");
        Assert.assertTrue(homePage.areResourcesLoaded(), "images src value loads incorrectly");
    }

    @Test
    public void testLoginLockedOutUser() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.assertPageOpened();
        loginPage.fillInputs(UserEnum.LOCKED_OUT);
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isBlockedTextPresent(), "Blocked text is not present");
    }

    @Test
    public void testLoginProblemUser() {
        HomePage page = LoginService.loginPage(getDriver(), UserEnum.PROBLEM);
        Assert.assertFalse(page.areResourcesLoaded(), "images src value load correctly");
    }

    @Test(dataProvider = "ProductProvider", dataProviderClass = com.solvd.carina.demo.utils.DataProvider.class)
    public void testPictureLinkClick(String TUID, int a, String b) {
        HomePage page = LoginService.loginPage(getDriver(), UserEnum.STANDARD);
        page.assertPageOpened();
        ElementPage elementPage = page.clickImage(a, b);
        elementPage.assertPageOpened();
    }


    @Test
    public void openHomePageWithCookies() { // not working, TO BE FIXED.
        HomePage homePage = new HomePage(getDriver());
        homePage.addCookie(new Cookie("session-username", "standard_user", "www.saucedemo.com", "/", DateUtils.addHours(new Date(), 2)));
        homePage.open();
        homePage.isPageOpened();
    }

    @Test(dataProvider = "ProductNameProvider", dataProviderClass = DataProvider.class)
    public void testAddToCart(String TUID, String b) {
        HomePage page = LoginService.loginPage(getDriver(), UserEnum.STANDARD);
        page.assertPageOpened();
        page.clickAddToCart(b);
        Assert.assertTrue(page.getNavBar().productWasAdded(), "Product wasn't added correctly");
    }

    @Test
    public void testPurchase() throws InterruptedException {
        //HomePage
        HomePage homePage = LoginService.loginPage(getDriver(), UserEnum.STANDARD);
        homePage.clickAddToCart("Sauce Labs Bolt T-Shirt");
        homePage.pause(3);
        // CartPage
        CartPage cartPage = homePage.clickCart();
        cartPage.pause(3);
        // First Checkout
        CheckOutPage checkOutPage = cartPage.clickCheckOut();
        checkOutPage.pause(3);
        checkOutPage.fillInputs();
        // Second Checkout
        CheckOut2Page checkOut2Page = checkOutPage.clickContinue();
        checkOut2Page.pause(3);
        // Checkout Complete
        CheckOutCompletePage completePage = checkOut2Page.clickFinish();
        completePage.assertPageOpened();
        completePage.pause(3);
    }
}
