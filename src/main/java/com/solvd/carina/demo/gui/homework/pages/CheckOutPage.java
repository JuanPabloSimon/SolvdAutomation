package com.solvd.carina.demo.gui.homework.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.homework.homewokComponents.NavBar;
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

    public void fillInputs(String firstname, String lastname, String postalCode) {
        this.nameInput.type(firstname);
        this.lastnameInput.type(lastname);
        this.postalCode.type(postalCode);
    }

    public CheckOut2Page clickContinue() {
        this.continueButton.click();
        return new CheckOut2Page(driver);
    }
}
