package com.solvd.carina.demo.homework.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.demo.homework.mobile.common.HomePageBase;
import com.solvd.carina.demo.homework.mobile.common.IncognitoPageBase;
import com.solvd.carina.demo.homework.mobile.common.SettingsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(id = "search_provider_logo")
    private ExtendedWebElement title;
    @FindBy(id = "search_box_text")
    private ExtendedWebElement searchInput;

    @FindBy(id = "url_bar")
    private ExtendedWebElement searchUrl;

    @FindBy(id = "menu_button")
    private ExtendedWebElement menuButton;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"New incognito tab\"]")
    private ExtendedWebElement incognitoButton;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Settings\"]")
    private ExtendedWebElement settingsButton;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    @Override
    public void fillSearchInput(String search) {
        searchInput.click();
        searchUrl.type(search);
        searchUrl.sendKeys(Keys.ENTER);
    }

    @Override // Method to be fixed
    public void clickEnter() {
        this.searchUrl.sendKeys(Keys.ENTER);
    }

    @Override
    public void clickMenu() {
        menuButton.click();
    }

    @Override
    public IncognitoPageBase clickIncognitoTab() {
        incognitoButton.click();
        return initPage(getDriver(), IncognitoPageBase.class);
    }

    @Override
    public SettingsPageBase clickSettings() {
        settingsButton.click();
        return initPage(getDriver(), SettingsPageBase.class);
    }

}
