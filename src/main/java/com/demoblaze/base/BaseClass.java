package com.demoblaze.base;

import com.demoblaze.utils.TestUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public static Properties propFile = new Properties();

    //Setting up Properties File
    public BaseClass(){
        try{
            FileInputStream inputFile = new FileInputStream("/Users/davidc/Documents/Testing/POMDemoBlazeTest/src/main/java/com/demoblaze/config/propsFile.properties");
            propFile.load(inputFile);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //Setting up Multi-Browser Driver
    public static void initBrowser() throws InterruptedException {
        String browser = propFile.getProperty("browser");

        if (browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if (browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }
        driver.get(propFile.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.IMPLICIT_WAIT));
    }

    public static void waitFor(WebElement element){
        new WebDriverWait(driver,Duration.ofSeconds(TestUtils.WEBDRIVER_WAIT)).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForAlert(){
        new WebDriverWait(driver,Duration.ofSeconds(TestUtils.WEBDRIVER_WAIT)).ignoring(NoAlertPresentException.class).until(ExpectedConditions.alertIsPresent());
    }

    public static void waitForClick(WebElement element){
        new WebDriverWait(driver,Duration.ofSeconds(TestUtils.WEBDRIVER_WAIT)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
        new WebDriverWait(driver,Duration.ofSeconds(TestUtils.WEBDRIVER_WAIT)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void handlingStaleElementError(WebElement element) {
        boolean staleElementError = true;

        while (staleElementError) {
            try {
                element.click();
                staleElementError = false;
            } catch (StaleElementReferenceException e) {
                e.printStackTrace();
            }
        }
    }

        public void handlingStaleElementError(Alert alert) {

            try {
                alert.dismiss();
            } catch (StaleElementReferenceException e) {
                alert.dismiss();
            }

    }

    public void dynamicItemSelector(String item) {

        List<WebElement> phones = driver.findElements(By.cssSelector(".hrefch"));
        for (WebElement phone : phones) {
            if (phone.getText().equals(item)) {
                phone.click();
                System.out.println("Selected Item was " + item + " and it was successfully added to Cart");
                break;
            }
        }
        }




}

