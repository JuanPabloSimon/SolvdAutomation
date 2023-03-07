package com.solvd.carina.demo.gui.homeworkPages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckOut2Page extends AbstractPage {

    @FindBy(id = "finish")
    private ExtendedWebElement finishButton;

    public CheckOut2Page(WebDriver webDriver) {
        super(webDriver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(finishButton);
        setPageURL("checkout-step-two.html");
    }

    public CheckOutCompletePage clickFinish() {
        this.finishButton.click();
        return new CheckOutCompletePage(driver);
    }
}