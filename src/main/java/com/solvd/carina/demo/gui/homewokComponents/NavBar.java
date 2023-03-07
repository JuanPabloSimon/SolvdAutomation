package com.solvd.carina.demo.gui.homewokComponents;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavBar extends AbstractUIObject {

    @FindBy(xpath = "./div[@class='header_label']")
    private ExtendedWebElement pageTitle;

    @FindBy(css = "a.shopping_cart_link")
    private ExtendedWebElement cartLink;

    @FindBy(xpath = ".//div[@class='bm-menu-wrap']")
    private ExtendedWebElement wrapMenu;

    public NavBar(WebDriver webDriver, SearchContext searchContext) {
        super(webDriver, searchContext);
        setUiLoadedMarker(wrapMenu);
    }

    public boolean productWasAdded() {
        WebElement itemsNumber = driver.findElement(By.cssSelector("span.shopping_cart_badge"));
        return itemsNumber != null;
    }

    public ExtendedWebElement getPageTitle() {
        return pageTitle;
    }

    public ExtendedWebElement getCartLink() {
        return cartLink;
    }

    public ExtendedWebElement getWrapMenu() {
        return wrapMenu;
    }
}
