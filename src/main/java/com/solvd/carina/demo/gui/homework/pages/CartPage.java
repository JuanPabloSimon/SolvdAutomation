package com.solvd.carina.demo.gui.homework.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.homework.homewokComponents.CartItem;
import com.solvd.carina.demo.gui.homework.homewokComponents.NavBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractPage {

    @FindBy(css = "div.primary_header")
    private NavBar navBar;

    @FindBy(css = "div.cart_item")
    private List<CartItem> cartList;

    @FindBy(css = "button.checkout_button")
    private ExtendedWebElement checkOutButton;

    public CartPage(WebDriver webDriver) {
        super(webDriver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(checkOutButton);
    }

    public boolean checkProductPresence(String title) {
        for (CartItem cartItem : cartList) {
            if (cartItem.checkCorrectTitle(title))
                return true;
        }
        return false;
    }

    public CheckOutPage clickCheckOut() {
        checkOutButton.click();
        return new CheckOutPage(driver);
    }
}
