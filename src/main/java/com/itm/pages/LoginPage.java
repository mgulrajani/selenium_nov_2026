package com.itm.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.itm.base.BaseTest;

public class LoginPage {

   Logger logger = LogManager.getLogger(LoginPage.class);
    private WebDriver driver;

    private By username =
            By.id("user-name");

    private By password =
            By.id("password");

    private By loginBtn =
            By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        System.out.println("LoginPage driver: " + driver);
    }

    public InventoryPage login(
            String user,
            String pass) {

                logger.info("Logging in with user: " + user);   
        driver.findElement(username)
              .sendKeys(user);
                logger.info("Entering password: " + pass);              
        driver.findElement(password)
              .sendKeys(pass);
  logger.info("Clicking login button");
        driver.findElement(loginBtn)
              .click();

        return new InventoryPage(driver);
    }
}