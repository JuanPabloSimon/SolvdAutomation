package com.solvd.carina.demo.homework.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class TermsConditionsPageBase extends AbstractPage {

    public TermsConditionsPageBase(WebDriver webDriver) {
        super(webDriver);
    }

    public abstract SignInPageBase clickAccept();
}
