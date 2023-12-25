package com.tests;

import com.pages.*;
import com.utils.SauceDemoBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SauceDemoTest extends SauceDemoBase {

    @Test
    public void sauceDemoTask1Test() {

        MainPage mainPage = new LoginPage(driver).login(USER_NAME, PASSWORD);

        mainPage.scrollPageToElement(mainPage.getLinkedInButton());
        LinkedInPage linkedInPage = mainPage.openLinkedIn();
        linkedInPage.switchToWindow(1);

        Assert.assertTrue(linkedInPage.getTitle().contains(WEBSITE_TITLE), String.format("The page title does not contain %s", WEBSITE_TITLE));

        mainPage.closeThePage();
        mainPage.switchToWindow(0);
        LoginPage loginPage = mainPage.logout();

        Assert.assertEquals(loginPage.getCurrentUrl(), SAUCE_DEMO_URL, "Current page, is not the login page.");
    }

    @Test
    public void sauceDemoCase2Test() {
        CheckoutCompletePage checkoutCompletePage = new LoginPage(driver)
                .login(USER_NAME, PASSWORD)
                .addBiggerPriceItemInCart()
                .openCart()
                .clickCheckoutButton()
                .fillUpInformationForm(NAME, LAST_NAME, POST_CODE)
                .clickContinue()
                .clickFinishButton();
        Assert.assertEquals(CHECKOUT_COMPLETE_MESSAGE, checkoutCompletePage.getCheckoutCompleteMessage());
    }
}
