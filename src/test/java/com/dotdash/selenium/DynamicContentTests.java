package com.dotdash.selenium;

import com.dotdash.selenium.pages.DynamicContentPage;
import com.dotdash.selenium.pages.HomePage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DynamicContentTests extends SetUpTearDown {
    HomePage homePage;
    DynamicContentPage dynamicContentPage;

    @Before
    public void init(){
        homePage = new HomePage(driver);
        dynamicContentPage = new DynamicContentPage(driver);
    }

    @Test
    public void verifyContentChangesAfterEachPageRefresh(){
        homePage.clickDynamicContentLink();
        String originalAvatar = dynamicContentPage.getFirstRowAvatar();
        String originalText = dynamicContentPage.getFirstRowText();

        dynamicContentPage.refreshPage(); // First refresh

        Assert.assertNotEquals(originalAvatar,dynamicContentPage.getFirstRowAvatar());
        Assert.assertNotEquals(originalText,dynamicContentPage.getFirstRowText());

        dynamicContentPage.refreshPage(); //Second refresh

        Assert.assertNotEquals(originalAvatar,dynamicContentPage.getFirstRowAvatar());
        Assert.assertNotEquals(originalText,dynamicContentPage.getFirstRowText());
    }
}