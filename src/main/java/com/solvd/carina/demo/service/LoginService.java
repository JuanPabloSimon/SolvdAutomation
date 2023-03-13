package com.solvd.carina.demo.service;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.solvd.carina.demo.gui.homework.pages.HomePage;
import com.solvd.carina.demo.gui.homework.pages.LoginPage;
import com.solvd.carina.demo.utils.UserEnum;
import com.zebrunner.carina.utils.R;

public class LoginService implements IDriverPool {

    public HomePage loginPage(UserEnum user) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.assertPageOpened();
        loginPage.fillInputs(user, R.TESTDATA.get("password"));
        return loginPage.clickLogin();
    }
}
