package com.solvd.carina.demo.gui.homeworkPages;

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

    public LoginPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(usernameInput);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public void fillInputs(UserEnum user) {
        if (user != null) {
            this.usernameInput.type(R.TESTDATA.get(user.getCredential()));
            this.passwordInput.type(R.TESTDATA.get("password"));
        }
    }

    public HomePage clickLoginSuccess() {
        this.loginButton.click();
        return new HomePage(driver);
    }

    public LoginBlockedPage clickLoginBlocked() {
        this.loginButton.click();
        return new LoginBlockedPage(driver);
    }

}
