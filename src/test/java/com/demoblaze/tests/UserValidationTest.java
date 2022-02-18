package com.demoblaze.tests;

import com.demoblaze.base.BaseClass;
import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.LoggedUserPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserValidationTest extends BaseClass {

    HomePage homePage;
    LoggedUserPage loggedUserPage;

    public UserValidationTest(){ super(); }

    @BeforeMethod
    public void browserSetup() throws InterruptedException {
        initBrowser();
        homePage = new HomePage();
        loggedUserPage = new LoggedUserPage();
    }

//    @Test
//    public void signUpNewUserTest() throws InterruptedException {
//        String titlePage = homePage.validateHomePage();
//        Assert.assertEquals(titlePage,"STORE");
//        String userSignUpMsg = homePage.createNewUser(propFile.getProperty("username"),propFile.getProperty("password"));
//        Assert.assertEquals(userSignUpMsg,"Sign up successful.");
//    }

    @Test(priority = 2)
    public void userLoginTest(){

        homePage.userLogin(propFile.getProperty("username"),propFile.getProperty("password"));
        String userDisplayed = loggedUserPage.validateLoggedUser();
        Assert.assertEquals(userDisplayed,"Welcome "+ propFile.getProperty("username"));
        loggedUserPage.userLogout();
    }

    @Test (priority = 3)
    public void invalidUserTest(){

        homePage.userLogin(propFile.getProperty("invaliduser"),propFile.getProperty("invalidpassword"));
        String invalidUserAlert = homePage.validateAlert();
        Assert.assertEquals(invalidUserAlert,"User does not exist.");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
