package com.solvd.carina.web.homework;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.gui.pages.WebPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testNewsSearch() {
        WebPage webPage = new WebPage(getDriver());
        webPage.open();
        Assert.assertTrue(webPage.isPageOpened(), "Home page is not opened!");
        String msg = "Lambdas";

        webPage.search(msg);
        
    }
}
