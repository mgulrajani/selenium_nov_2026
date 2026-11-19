package com.itm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.itm.base.BaseTest;
import com.itm.pages.InventoryPage;
import com.itm.pages.LoginPage;

public class AddToCartTest
                    extends BaseTest {

    @Test
    public void addProductToCart() {

        LoginPage loginPage =
                new LoginPage(driver);

        InventoryPage inventoryPage =
                loginPage.login(
                        "standard_user",
                        "secret_sauce");

        inventoryPage.addBackpackToCart();

        Assert.assertTrue(true);
    }
}
