package com.solvd.carina.demo.gui.homewokComponents;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class InventoryItem extends AbstractUIObject {

    private int productId;

    @FindBy(xpath = "./div/a/img")
    private ExtendedWebElement productImage;

    @FindBy(xpath = "./div/a")
    private ExtendedWebElement productLink;

    @FindBy(xpath = "./div/div[@class='inventory_item_label']")
    private ExtendedWebElement itemLabel;

    @FindBy(xpath = "./div/div/button")
    private ExtendedWebElement addElementButton;

    public InventoryItem(WebDriver webDriver, SearchContext searchContext) {
        super(webDriver, searchContext);
    }

    public ExtendedWebElement getProductImage() {
        return productImage;
    }

    public ExtendedWebElement getProductLink() {
        return productLink;
    }

    public ExtendedWebElement getItemLabel() {
        return itemLabel;
    }

    public ExtendedWebElement getAddElementButton() {
        return addElementButton;
    }
}
