package com.solvd.carina.demo.homework.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.homework.mobile.utils.EngineType;
import org.openqa.selenium.WebDriver;

public abstract class SettingsPageBase extends AbstractPage {

    public SettingsPageBase(WebDriver webDriver) {
        super(webDriver);
    }

    public abstract void selectEngine(EngineType engine);

    public abstract boolean checkSelected(EngineType engine);
}
