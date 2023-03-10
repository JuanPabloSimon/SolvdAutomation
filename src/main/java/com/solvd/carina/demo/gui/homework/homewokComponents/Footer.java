package com.solvd.carina.demo.gui.homework.homewokComponents;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Footer extends AbstractUIObject {
    @FindBy(xpath = "//ul[@class='social']/li")
    private List<ExtendedWebElement> contacts;
    @FindBy(css = "div.footer_user")
    private ExtendedWebElement copy;

    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

}
