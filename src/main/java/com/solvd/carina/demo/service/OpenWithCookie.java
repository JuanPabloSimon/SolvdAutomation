package com.solvd.carina.demo.service;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.solvd.carina.demo.gui.homework.pages.HomePage;
import com.solvd.carina.demo.gui.homework.pages.LoginPage;
import com.zebrunner.carina.utils.R;
import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.Cookie;

import java.util.Date;

public class OpenWithCookie implements IDriverPool {
    public HomePage openWithCookie() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.addCookie(new Cookie(R.TESTDATA.get("cookie_name"),
                R.TESTDATA.get("cookie_value"),
                R.TESTDATA.get("cookie_domain"),
                R.TESTDATA.get("cookie_path"),
                DateUtils.addHours(new Date(), 2)));
        return new HomePage(getDriver());
    }
}
