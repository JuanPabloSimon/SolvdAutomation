package com.solvd.carina.demo.gui.homework.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.homework.homewokComponents.Footer;
import com.solvd.carina.demo.gui.homework.homewokComponents.InventoryItem;
import com.solvd.carina.demo.gui.homework.homewokComponents.NavBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//span[text()='Products']")
    private ExtendedWebElement productTitle;

    @FindBy(css = "div.inventory_item")
    private List<InventoryItem> items;

    @FindBy(className = "footer")
    private Footer footer;

    @FindBy(css = "div.primary_header")
    private NavBar navBar;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(productTitle);
        setPageURL("inventory.html");
    }

    public ElementPage clickImage(String title) {
        InventoryItem container = null;
        for (InventoryItem element : items) {
            if (element.getItemTitle().getText().equalsIgnoreCase(title))
                container = element;
        }
        if (container != null)
            container.getProductLink().click();
        return new ElementPage(driver);
    }

    public boolean areResourcesLoaded() {
        for (int i = 0; i < items.size() - 1; i++) {
            for (int k = i + 1; k < items.size(); k++) {
                if (items.get(i).getProductImage().getAttribute("src").equals(items.get(k).getProductImage().getAttribute("src")))
                    return false;
            }
        }
        return true;
    }

    public void clickAddToCart(String title) {
        InventoryItem container = null;
        for (InventoryItem item : items) {
            if (item.getItemTitle().getText().equalsIgnoreCase(title))
                container = item;
        }
        if (container != null)
            container.getAddElementButton().click();
    }

    public CartPage clickCart() {
        navBar.getCartLink().click();
        return new CartPage(driver);
    }

    public NavBar getNavBar() {
        return this.navBar;
    }
}
