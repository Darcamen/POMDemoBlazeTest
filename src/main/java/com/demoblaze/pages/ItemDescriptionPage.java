package com.demoblaze.pages;

import com.demoblaze.base.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemDescriptionPage extends BaseClass {

    public ItemDescriptionPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".btn.btn-success.btn-lg")
    WebElement addToCartBtn;

    @FindBy(xpath = "//a[@class='nav-link'][1]")
    public WebElement homeOptn;

    public void dynamicAddToCart(){
        handlingStaleElementError(addToCartBtn);
        driver.navigate().refresh();
        homeOptn.click();
    }
}
