package com.solvd.carina.demo.homework.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.demo.homework.mobile.common.SignInPageBase;
import com.solvd.carina.demo.homework.mobile.common.TermsConditionsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = TermsConditionsPageBase.class)
public class TermsConditionsPage extends TermsConditionsPageBase {

    @FindBy(id = "terms_accept")
    private ExtendedWebElement acceptButton;

    public TermsConditionsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public boolean isPageOpened() {
        return acceptButton.isElementPresent();
    }

    @Override
    public SignInPageBase clickAccept() {
        this.acceptButton.click();
        return initPage(getDriver(), SignInPageBase.class);
    }
}
