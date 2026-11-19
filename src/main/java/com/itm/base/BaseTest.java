package com.itm.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod; 

public class BaseTest {

    protected WebDriver driver;
    protected static Logger logger =
    LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    public void setup() {

        System.out.println("in the base test setup method");
        driver = new ChromeDriver();
        System.out.println("BaseTest driver: in setup method " + this.driver);
        driver.manage().window().maximize();

        driver.get(
            "https://www.saucedemo.com");
    }

    @AfterMethod
    public void tearDown() {
try{
        if(driver != null) {
            driver.quit();
        }
}
catch(Exception e){
    System.out.println("Exception in tearDown: " + e.getMessage());
}
finally{
    if(driver != null) {
        driver.quit();
    }
}
    }

    public WebDriver getDriver() {
       
     return driver;
    }   
    
}

