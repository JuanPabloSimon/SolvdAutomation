package com.solvd.carina.demo.homework.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver webDriver) {
        super(webDriver);
    }

    public abstract void fillSearchInput();

    public abstract void clickEnter();
}
