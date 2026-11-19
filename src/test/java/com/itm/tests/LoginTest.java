package com.itm.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.itm.base.BaseTest;
@Listeners (com.itm.listeners.ScreenshotListener.class)     
public class LoginTest extends BaseTest {   

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name"))
              .sendKeys("standard_user");

        driver.findElement(By.id("password"))
              .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
              .click();

        String title = driver.findElement(
                By.className("title")).getText();

        if(title.equals("Products")) {
            System.out.println("Login Successful");
        }

        Assert.assertEquals("Products", title);

        driver.quit();
    }
}