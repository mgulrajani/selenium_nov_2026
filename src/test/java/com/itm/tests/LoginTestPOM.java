package com.itm.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.itm.base.BaseTest;
import com.itm.dataproviders.LoginDataProvider;
import com.itm.pages.InventoryPage;
import com.itm.pages.LoginPage;
@Listeners (com.itm.listeners.ExtentListener.class)
public class LoginTestPOM extends BaseTest {

    @Test
    public void verifyLogin() {

        LoginPage loginPage =
                new LoginPage(driver);

        InventoryPage inventoryPage    =    
                loginPage.login(
                        "standard_user",
                        "secret_sauce");
                        

        /* 
                loginPage.login(
                        "standard_user",
                        "secret_sauce");
*/

WebDriverWait wait =
        new WebDriverWait(driver,
                Duration.ofSeconds(10));

wait.until(
        ExpectedConditions.urlContains(
                "inventory.html"));


    System.out.println(driver.getCurrentUrl());

    String title =
        driver.findElement(By.className("title"))
              .getText();
    System.out.println(title);
        Assert.assertEquals(
                inventoryPage.getTitle(),
                "Products");
    }

@Test(
    dataProvider = "loginData",
    dataProviderClass =
        LoginDataProvider.class)
public void verifyLogin(
        String username,
        String password) {
    InventoryPage inventoryPage =
            new LoginPage(driver)
                    .login(
                        username,
                        password);
    Assert.assertTrue(
            inventoryPage.isLoaded());
}



}