package com.solvd.carina.demo.service;

import com.solvd.carina.demo.gui.homework.pages.HomePage;
import com.solvd.carina.demo.gui.homework.pages.LoginPage;
import com.solvd.carina.demo.utils.UserEnum;
import org.openqa.selenium.WebDriver;

public class LoginService {

    public static HomePage loginPage(WebDriver driver, UserEnum user) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.assertPageOpened();
        loginPage.fillInputs(user);
        return loginPage.clickLogin();
    }
}
