package com.demoblaze.pages;

import com.demoblaze.base.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BaseClass {

    //Initializing Page Objects
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    //Page Objects Repository
    @FindBy(css = ".carousel-inner")
    public WebElement homePageImage;

    @FindBy(css = "a#login2")
    public WebElement loginOptn;

    @FindBy(xpath = "//a[@id='signin2']")
    public WebElement signUpOptn;

    @FindBy(css = "h5#signInModalLabel")
    public WebElement signUpMdl;

    @FindBy(css = "h5#logInModalLabel")
    public WebElement logInMdl;

    @FindBy(id = "sign-username")
    public WebElement userName;

    @FindBy(id = "loginusername")
    public WebElement logInUserMame;

    @FindBy(id = "sign-password")
    public WebElement passwd;

    @FindBy(id = "loginpassword")
    public WebElement logInPwd;

    @FindBy(xpath = "//button[text()='Sign up']")
    public WebElement signUpBtn;

    @FindBy(xpath = "//button[text()='Log in']")
    public WebElement logInBtn;

    @FindBy(xpath = ("(//button[@class='btn btn-secondary'])[2]"))
    public WebElement closeSignUpBtn;

    @FindBy(xpath = ("(//button[@class='btn btn-secondary'])[3]"))
    public WebElement closeLogInBtn;

    @FindBy(xpath = "//a[@id='itemc'][1]")
    public WebElement phonesCategory;

    //Action Methods

    public String validateHomePage() {
        System.out.println("Page Name is: " + driver.getTitle());
        return driver.getTitle();

    }

    public String createNewUser(String user, String pwd) {
        signUpOptn.click();
        waitFor(signUpMdl);
        userName.sendKeys(user);
        passwd.sendKeys(pwd);
        signUpBtn.click();
        waitForAlert();
        System.out.println("Alert message says: " + driver.switchTo().alert().getText());
        return driver.switchTo().alert().getText();
    }

    public void userLogin(String user, String pwd) {
        loginOptn.click();
        waitFor(logInMdl);
        logInUserMame.sendKeys(user);
        logInPwd.sendKeys(pwd);
        logInBtn.click();
    }

    public String validateAlert() {
        waitForAlert();
        System.out.println("Alert message says: " + driver.switchTo().alert().getText());
        return driver.switchTo().alert().getText();
    }

    public void selectCategory() throws StaleElementReferenceException {
        handlingStaleElementError(phonesCategory);
    }
}
