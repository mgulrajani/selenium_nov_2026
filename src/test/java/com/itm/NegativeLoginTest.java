package com.itm;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class NegativeLoginTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com");
            driver.findElement(By.id("user-name"))
                  .sendKeys("invalid_user");
            driver.findElement(By.id("password"))
                  .sendKeys("wrong_password");
            driver.findElement(By.id("login-button"))
                  .click();
            WebDriverWait wait =
                    new WebDriverWait(driver,
                            Duration.ofSeconds(10));
            WebElement errorMessage =
                    wait.until(
                            ExpectedConditions
                                    .visibilityOfElementLocated(
                                            By.cssSelector("h3[data-test='error']")));
            String actualMessage =
                    errorMessage.getText();
            Assert.assertEquals(
                    actualMessage,
                    "Epic sadface: Username and password do not match any user in this service");
            Assert.assertFalse(
                    driver.getCurrentUrl().contains("inventory.html"),
                    "User should not be logged in");
            System.out.println("Negative Login Test Passed");
        } finally {
            driver.quit();
        }
    }
}

