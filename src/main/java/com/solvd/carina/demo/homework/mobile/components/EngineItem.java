package com.solvd.carina.demo.homework.mobile.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class EngineItem extends AbstractUIObject {

    @FindBy(xpath = ".//android.widget.LinearLayout/android.widget.TextView[1]")
    private ExtendedWebElement engineName;

    @FindBy(xpath = ".//android.widget.RadioButton")
    private ExtendedWebElement checkButton;

    public EngineItem(WebDriver webDriver, SearchContext searchContext) {
        super(webDriver, searchContext);
    }

    public boolean checkElementName(String name) {
        return engineName.getText().equalsIgnoreCase(name);
    }

    public boolean isChecked() {
        return checkButton.getAttribute("checked").equalsIgnoreCase("true");
    }

    public void clickCheckButton() {
        this.checkButton.click();
    }
}
