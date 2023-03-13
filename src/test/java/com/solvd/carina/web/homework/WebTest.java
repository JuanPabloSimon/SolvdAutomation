package com.solvd.carina.web.homework;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.gui.homework.pages.*;
import com.solvd.carina.demo.service.LoginService;
import com.solvd.carina.demo.service.OpenWithCookie;
import com.solvd.carina.demo.utils.UserEnum;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testLoginStandardUser() {
        HomePage homePage = new LoginService().loginPage(UserEnum.STANDARD);
        homePage.isPageOpened(2);
        Assert.assertTrue(homePage.areResourcesLoaded(), "Images src value loads incorrectly");
    }

    @Test
    public void testLoginLockedOutUser() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.assertPageOpened(3);
        loginPage.fillInputs(UserEnum.LOCKED_OUT, R.TESTDATA.get("password"));
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isBlockedTextPresent(), "Blocked text is not present");
    }

    @Test
    public void testLoginProblemUser() {
        HomePage page = new LoginService().loginPage(UserEnum.PROBLEM);
        Assert.assertFalse(page.areResourcesLoaded(), "Images src value load correctly");
    }

    @Test(dataProvider = "ProductProvider", dataProviderClass = com.solvd.carina.demo.utils.DataProvider.class)
    public void testPictureLinkClick(String TUID, String title) {
        HomePage page = new LoginService().loginPage(UserEnum.STANDARD);
        page.assertPageOpened(3);
        ElementPage elementPage = page.clickImage(title);
        elementPage.assertPageOpened(3);
        Assert.assertTrue(elementPage.isCorrectPageOpened(title), "The page opened doesn't match the selected image");
    }
    
    @Test
    public void openHomePageWithCookiesTest() {
        HomePage homePage = new OpenWithCookie().openWithCookie();
        homePage.open();
        homePage.assertPageOpened(3);
    }

    @Test(dataProvider = "ProductProvider", dataProviderClass = com.solvd.carina.demo.utils.DataProvider.class)
    public void testAddToCart(String TUID, String b) {
        HomePage homePage = new OpenWithCookie().openWithCookie();
        homePage.open();
        homePage.assertPageOpened(3);
        homePage.clickAddToCart(b);
        Assert.assertTrue(homePage.getNavBar().productWasAdded(), "Product wasn't added correctly");
        CartPage cartPage = homePage.clickCart();
        cartPage.assertPageOpened(3);
        Assert.assertTrue(cartPage.checkProductPresence(b));
    }

    @Test
    public void testPurchase() throws InterruptedException {
        //HomePage
        HomePage homePage = new LoginService().loginPage(UserEnum.STANDARD);
        homePage.clickAddToCart("Sauce Labs Bolt T-Shirt");
        homePage.pause(3);
        // CartPage
        CartPage cartPage = homePage.clickCart();
        cartPage.pause(3);
        // First Checkout
        CheckOutPage checkOutPage = cartPage.clickCheckOut();
        checkOutPage.pause(3);
        checkOutPage.fillInputs(R.TESTDATA.get("firstName"), R.TESTDATA.get("lastName"), R.TESTDATA.get("postalCode"));
        // Second Checkout
        CheckOut2Page checkOut2Page = checkOutPage.clickContinue();
        checkOut2Page.pause(3);
        // Checkout Complete
        CheckOutCompletePage completePage = checkOut2Page.clickFinish();
        completePage.assertPageOpened(3);
        completePage.pause(3);
    }
}
