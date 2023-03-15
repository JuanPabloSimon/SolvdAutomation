package com.solvd.carina.demo.homework.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.demo.homework.mobile.common.IncognitoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = IncognitoPageBase.class)
public class IncognitoPage extends IncognitoPageBase {


    @FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"New incognito tab\"]/android.widget.LinearLayout/android.widget.TextView[1]")
    private ExtendedWebElement incognitoTitle;

    public IncognitoPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public boolean isPageOpened() {
        return incognitoTitle.isElementPresent(3);
    }
}
