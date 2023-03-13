package com.solvd.carina.demo.gui.homework.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.homework.homewokComponents.NavBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ElementPage extends AbstractPage {

    @FindBy(css = "div.inventory_details_name")
    private ExtendedWebElement productTitle;
    @FindBy(css = "div.primary_header")
    private NavBar navBar;

    public ElementPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(productTitle);
    }

    public boolean isCorrectPageOpened(String title) {
        return productTitle.getText().equalsIgnoreCase(title);
    }
}
