package com.solvd.carina.demo.homework.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.demo.homework.mobile.common.HomePageBase;
import com.solvd.carina.demo.homework.mobile.common.SignInPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SignInPageBase.class)
public class SignInPage extends SignInPageBase {

    @FindBy(id = "signin_title")
    private ExtendedWebElement signInTitle;

    @FindBy(id = "positive_button")
    private ExtendedWebElement signInButton;
    @FindBy(id = "negative_button")
    private ExtendedWebElement noThanksButton;

    public SignInPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public boolean isPageOpened() {
        return this.signInTitle.isElementPresent();
    }

    @Override
    public HomePageBase clickNoThanks() {
        this.noThanksButton.click();
        return initPage(getDriver(), HomePageBase.class);
    }
}
