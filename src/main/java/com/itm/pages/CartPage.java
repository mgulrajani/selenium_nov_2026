package com.itm.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    private By cartTitle = By.className("title");

    private By checkoutButton = By.id("checkout");

    private By continueShoppingButton =
            By.id("continue-shopping");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {

        return driver.findElement(cartTitle)
                     .getText();
    }

    public CheckoutPage clickCheckout() {

        driver.findElement(checkoutButton)
              .click();

        return new CheckoutPage(driver);
    }

    public void continueShopping() {

        driver.findElement(continueShoppingButton)
              .click();
    }
}