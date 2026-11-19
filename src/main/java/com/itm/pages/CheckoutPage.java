package com.itm.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.itm.base.BaseTest;

public class CheckoutPage {

    private WebDriver driver;

    private By firstName =
            By.xpath("//*[@id=\'first-name\']");

    private By lastName =
            By.xpath("//*[@id=\'last-name\']");

    private By postalCode =
            By.xpath("//*[@id=\'postal-code\']");

    private By continueButton =
            By.id("continue");

    private By cancelButton =
            By.id("cancel");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String fname) {

        driver.findElement(firstName)
              .sendKeys(fname);
    }

    public void enterLastName(String lname) {

        driver.findElement(lastName)
              .sendKeys(lname);
    }

    public void enterPostalCode(String zip) {

        driver.findElement(postalCode)
              .sendKeys(zip);
    }

    public CheckoutOverviewPage continueCheckout(
            String fname,
            String lname,
            String zip) {

        enterFirstName(fname);

        enterLastName(lname);

        enterPostalCode(zip);

        driver.findElement(continueButton)
              .click();

        return new CheckoutOverviewPage(driver);
    }
}