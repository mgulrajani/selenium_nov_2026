package com.itm.pages;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.itm.base.BaseTest;

public class InventoryPage {

    private WebDriver driver;
   Logger logger = LogManager.getLogger(InventoryPage.class);

    private By cartIcon =
            By.className("shopping_cart_link");

    private By title =
            By.className("title");

    private By backpackAddButton =
          //  By.id("add-to-cart-sauce-labs-backpack");
By.xpath("//*[@id=\'add-to-cart-sauce-labs-backpack\']");
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {

        return driver.findElement(title)
                     .getText();
    }

    public void addBackpackToCart() {
   logger.info("Adding backpack to cart");
        driver.findElement(
            backpackAddButton).click();

        logger.info("Backpack added to cart");
    }

   

        public CartPage goToCart() {

            driver.findElement(cartIcon).click();
        
            WebDriverWait wait =
                    new WebDriverWait(driver,
                            Duration.ofSeconds(10));
        
            wait.until(
                    ExpectedConditions.urlContains("cart"));
        
            return new CartPage(driver);
            }

            public boolean isLoaded() {
                return driver.getCurrentUrl()
                             .contains("inventory.html");
            }
            
}