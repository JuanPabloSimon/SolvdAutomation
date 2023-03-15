package com.solvd.carina.demo.homework.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.demo.homework.mobile.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(id = "search_provider_logo")
    private ExtendedWebElement title;
    @FindBy(id = "search_box_text")
    private ExtendedWebElement searchInput;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    @Override
    public void fillSearchInput() {

    }

    @Override
    public void clickEnter() {

    }


}
