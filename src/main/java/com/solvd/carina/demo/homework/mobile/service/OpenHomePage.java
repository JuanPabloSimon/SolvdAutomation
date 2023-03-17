package com.solvd.carina.demo.homework.mobile.service;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.solvd.carina.demo.homework.mobile.common.HomePageBase;
import com.solvd.carina.demo.homework.mobile.common.SignInPageBase;
import com.solvd.carina.demo.homework.mobile.common.TermsConditionsPageBase;
import org.testng.Assert;

public class OpenHomePage implements IDriverPool, IAbstractTest {

    public HomePageBase initChrome() {
        TermsConditionsPageBase termsPage = initPage(getDriver(), TermsConditionsPageBase.class);
        Assert.assertTrue(termsPage.isPageOpened(), "terms page does not appear");
        SignInPageBase signInPage = termsPage.clickAccept();
        Assert.assertTrue(signInPage.isPageOpened(), "Sign in page is not open");
        signInPage.clickNoThanks();
        return initPage(getDriver(), HomePageBase.class);
    }
}
