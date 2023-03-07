package com.solvd.carina.demo.gui.homeworkPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.homewokComponents.NavBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {

    @FindBy(css = "div.primary_header")
    private NavBar navBar;

    @FindBy(css = "div.cart_list")
    private ExtendedWebElement cartList;

    @FindBy(css = "button.checkout_button")
    private ExtendedWebElement checkOutButton;

    public CartPage(WebDriver webDriver) {
        super(webDriver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(checkOutButton);
        setPageURL("cart.html");
    }

    public CheckOutPage clickCheckOut() {
        checkOutButton.click();
        return new CheckOutPage(driver);
    }
}
