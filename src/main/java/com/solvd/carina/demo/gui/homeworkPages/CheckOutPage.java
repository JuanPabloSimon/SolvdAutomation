package com.solvd.carina.demo.gui.homeworkPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.homewokComponents.NavBar;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends AbstractPage {

    @FindBy(id = "first-name")
    private ExtendedWebElement nameInput;
    @FindBy(id = "last-name")
    private ExtendedWebElement lastnameInput;

    @FindBy(id = "postal-code")
    private ExtendedWebElement postalCode;

    @FindBy(id = "continue")
    private ExtendedWebElement continueButton;

    @FindBy(css = "div.primary_header")
    private NavBar navBar;

    public CheckOutPage(WebDriver webDriver) {
        super(webDriver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(continueButton);
        setPageURL("checkout-step-one.html");
    }

    public void fillInputs() {
        this.nameInput.type(R.TESTDATA.get("firstName"));
        this.lastnameInput.type(R.TESTDATA.get("lastName"));
        this.postalCode.type(R.TESTDATA.get("postalCode"));
    }

    public CheckOut2Page clickContinue() {
        this.continueButton.click();
        return new CheckOut2Page(driver);
    }
}
