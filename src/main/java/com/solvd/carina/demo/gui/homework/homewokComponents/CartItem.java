package com.solvd.carina.demo.gui.homework.homewokComponents;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartItem extends AbstractUIObject {

    @FindBy(xpath = ".//div[contains(@class, 'inventory_item_name')]")
    private ExtendedWebElement productTitle;

    @FindBy(xpath = ".//button")
    private ExtendedWebElement removeButton;

    public CartItem(WebDriver webDriver, SearchContext searchContext) {
        super(webDriver, searchContext);
    }

    public boolean checkCorrectTitle(String title) {
        return productTitle.getText().equalsIgnoreCase(title);
    }
}
