package com.solvd.carina.demo.gui.homework.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.utils.UserEnum;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class LoginPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//input[(@id='user-name')]")
    private ExtendedWebElement usernameInput;
    @FindBy(xpath = "//input[(@id='password')]")
    private ExtendedWebElement passwordInput;
    @FindBy(xpath = "//input[(@id='login-button')]")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//h3[text()='Epic sadface: Sorry, this user has been locked out.']")
    private ExtendedWebElement blockedText;

    public LoginPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(usernameInput);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public void fillInputs(UserEnum user, String password) {
        if (user != null) {
            this.usernameInput.type(R.TESTDATA.get(user.getCredential()));
            this.passwordInput.type(password);
        }
    }

    public HomePage clickLogin() {
        this.loginButton.click();
        return new HomePage(driver);
    }


    public boolean isBlockedTextPresent() {
        return blockedText.isElementPresent();
    }

}
