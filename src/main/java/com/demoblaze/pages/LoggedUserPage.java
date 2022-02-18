package com.demoblaze.pages;

import com.demoblaze.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedUserPage extends BaseClass {


    //Initializing Page Objects
    public LoggedUserPage(){
    PageFactory.initElements(driver,this);}

    //Page Objects Repository
    @FindBy(css = "a#logout2")
    WebElement logOutOptn;

    @FindBy(xpath = "//a[@id='cartur']")
    WebElement cartOption;

    @FindBy(id = "nameofuser")
    WebElement userNameOption;

    //Action Methods

    public String validateLoggedUser(){

        waitFor(userNameOption);
        System.out.println(userNameOption.getText());
        return userNameOption.getText();
    }

    public void userLogout(){

        logOutOptn.click();

    }


}
