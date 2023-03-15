package com.solvd.carina.mobile.homework;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.homework.mobile.common.TermsConditionsPageBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileTest implements IAbstractTest, IMobileUtils {

    @Test
    public void testChrome() {
        TermsConditionsPageBase termsPage = initPage(getDriver(), TermsConditionsPageBase.class);
        Assert.assertTrue(termsPage.isPageOpened());
//        termsPage.clickAccept();
    }
}
