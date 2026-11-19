package com.itm.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {

    private WebDriver driver;

    private By successMessage =
   //         By.className("complete-header");
By.xpath("//*[@id='checkout_complete_container']/h2");
    public CheckoutCompletePage(
            WebDriver driver) {

        this.driver = driver;
    }

    public String getSuccessMessage() {

        return driver.findElement(successMessage)
                     .getText();
    }
}