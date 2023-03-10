package com.solvd.carina.demo.gui.homework.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.homework.homewokComponents.NavBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckOutCompletePage extends AbstractPage {

    @FindBy(css = "h2.complete-header")
    private ExtendedWebElement completeHeader;

    @FindBy(css = "div.primary_header")
    private NavBar navBar;

    public CheckOutCompletePage(WebDriver webDriver) {
        super(webDriver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(completeHeader);
        setPageURL("checkout-complete.html");
    }
}
