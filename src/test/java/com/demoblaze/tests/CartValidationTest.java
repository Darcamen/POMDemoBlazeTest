package com.demoblaze.tests;

import com.demoblaze.base.BaseClass;
import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.ItemDescriptionPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartValidationTest extends BaseClass {

    HomePage homePage;
    ItemDescriptionPage itemDescriptionPage;

    public CartValidationTest(){
        super();
    }

    @BeforeMethod
    public void browserSetup() throws InterruptedException {
        initBrowser();
        homePage = new HomePage();
        itemDescriptionPage = new ItemDescriptionPage();
    }

    @Test
    public void itemToCartTest() {
        homePage.userLogin(propFile.getProperty("username"),propFile.getProperty("password"));
        homePage.selectCategory();
        dynamicItemSelector(propFile.getProperty("phoneModel1"));
        itemDescriptionPage.dynamicAddToCart();
        dynamicItemSelector(propFile.getProperty("phoneModel2"));
        itemDescriptionPage.dynamicAddToCart();
        homePage.clickOnCartOptn();

    }
}
