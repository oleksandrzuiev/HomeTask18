package com.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


public class SauceDemoBase {
    public WebDriver driver;
    public WebDriverWait wait;

    public final String SAUCE_DEMO_URL = "https://www.saucedemo.com/";
    public final String USER_NAME = "standard_user";
    public final String PASSWORD = "secret_sauce";
    public final String NAME = "John";
    public final String LAST_NAME = "Ford";
    public final String POST_CODE = "1234";
    public final String CHECKOUT_COMPLETE_MESSAGE = "Checkout: Complete!";
    public final String WEBSITE_TITLE = "LinkedIn";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(SAUCE_DEMO_URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
