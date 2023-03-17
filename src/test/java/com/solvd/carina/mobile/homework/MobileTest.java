package com.solvd.carina.mobile.homework;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.homework.mobile.common.*;
import com.solvd.carina.demo.homework.mobile.service.OpenHomePage;
import com.solvd.carina.demo.homework.mobile.utils.EngineType;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileTest implements IAbstractTest, IMobileUtils {


    /*
     Test not working, never pass the home page, instead of pressing enter just type a symbol.
     Validation missing.
     */
    @Test
    public void testSearch() {
        TermsConditionsPageBase termsPage = initPage(getDriver(), TermsConditionsPageBase.class);
        Assert.assertTrue(termsPage.isPageOpened(), "terms page does not appear");
        SignInPageBase signInPage = termsPage.clickAccept();
        Assert.assertTrue(signInPage.isPageOpened(), "Sign in page is not open");
        HomePageBase homePage = signInPage.clickNoThanks();
        Assert.assertTrue(homePage.isPageOpened(), "Google Home Page is not open");
        homePage.fillSearchInput(R.TESTDATA.get("search"));
    }

    @Test
    public void testIncognitoPage() {
        HomePageBase homePage = new OpenHomePage().initChrome();
        Assert.assertTrue(homePage.isPageOpened(), "Google Home Page is not open");
        homePage.clickMenu();
        IncognitoPageBase incognitoPage = homePage.clickIncognitoTab();
        Assert.assertTrue(incognitoPage.isPageOpened(), "Incognito Page was not opened");
    }

    @Test
    public void testChangeChromeEngine() {
        TermsConditionsPageBase termsPage = initPage(getDriver(), TermsConditionsPageBase.class);
        Assert.assertTrue(termsPage.isPageOpened(), "terms page does not appear");
        SignInPageBase signInPage = termsPage.clickAccept();
        Assert.assertTrue(signInPage.isPageOpened(), "Sign in page is not open");
        HomePageBase homePage = signInPage.clickNoThanks();
        Assert.assertTrue(homePage.isPageOpened(), "Google Home Page is not open");
        homePage.clickMenu();
        SettingsPageBase settingsPage = homePage.clickSettings();
        Assert.assertTrue(settingsPage.isPageOpened(), "Settings page is not opened");
        settingsPage.selectEngine(EngineType.YAHOO);
        Assert.assertTrue(settingsPage.checkSelected(EngineType.YAHOO), "Element was not selected");
        pause(2);
    }
}
