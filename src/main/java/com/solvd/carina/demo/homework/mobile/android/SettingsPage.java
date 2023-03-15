package com.solvd.carina.demo.homework.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.demo.homework.mobile.common.SettingsPageBase;
import com.solvd.carina.demo.homework.mobile.components.EngineItem;
import com.solvd.carina.demo.homework.mobile.utils.EngineType;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SettingsPageBase.class)
public class SettingsPage extends SettingsPageBase {

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView")
    private ExtendedWebElement settingsTitle;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout")
    private ExtendedWebElement searchEngineButton;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout")
    private List<EngineItem> engines;

    public SettingsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public boolean isPageOpened() {
        return settingsTitle.isElementPresent();
    }

    @Override
    public void selectEngine(EngineType engine) {
        searchEngineButton.click();
        for (EngineItem engineItem : engines) {
            if (engineItem.checkElementName(engine.getName())) {
                engineItem.clickCheckButton();
            }
        }
    }

    @Override
    public boolean checkSelected(EngineType engine) {
        EngineItem engineItem = engines.stream().filter(e -> e.checkElementName(engine.getName())).findFirst().orElse(null);
        return engineItem.isChecked();
    }

}
