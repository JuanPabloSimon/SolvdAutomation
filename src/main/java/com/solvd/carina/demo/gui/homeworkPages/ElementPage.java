package com.solvd.carina.demo.gui.homeworkPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.homewokComponents.NavBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ElementPage extends AbstractPage {

    @FindBy(css = "div.inventory_details_name")
    private ExtendedWebElement productTitle;
    
    @FindBy(css = "div.primary_header")
    private NavBar navBar;

    public ElementPage(WebDriver driver, int id) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageURL(String.format("inventory-item.html?id=%d", id));
    }
}
