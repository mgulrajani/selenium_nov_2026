package com.itm.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonSerializable.Base;
import com.itm.base.BaseTest;
import com.itm.pages.CartPage;
import com.itm.pages.CheckoutCompletePage;
import com.itm.pages.CheckoutOverviewPage;
import com.itm.pages.CheckoutPage;
import com.itm.pages.InventoryPage;
import com.itm.pages.LoginPage;
@Listeners (com.itm.listeners.ExtentListener.class) 
public class CheckoutTest extends BaseTest {
    
        

    @Test
public void verifyCheckoutFlow() {
try{
    LoginPage loginPage =
            new LoginPage(driver);
 
            System.out.println("CheckoutTest driver: " + this.driver);
    
            System.out.println("CheckoutTest Login Page: " + loginPage);
    
            InventoryPage inventoryPage =
            loginPage.login(
                    "standard_user",
                    "secret_sauce");

    inventoryPage.addBackpackToCart();
    Thread.sleep(1000, 0);
    CartPage cartPage =
            inventoryPage.goToCart();
    Thread.sleep(1000, 0);
    CheckoutPage checkoutPage =
            cartPage.clickCheckout();
   Thread.sleep(1000, 0);    
    CheckoutOverviewPage overviewPage =
            checkoutPage.continueCheckout(
                    "Muskaan",
                    "Gulrajani",
                    "400706");
Thread.sleep(1000, 0);
    CheckoutCompletePage completePage =
            overviewPage.finishOrder();
Thread.sleep(1000, 0);
    Assert.assertEquals(
            completePage.getSuccessMessage(),
            "Thank you for your order!");
}
catch(InterruptedException e){
    System.out.println("Exception occurred: " + e.getMessage());
    Assert.fail("Test failed due to exception: " + e.getMessage());
}
}
}

