package com.itm;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class GoogleTest {
@Test 
public void testGoogleSearch() {
    System.out.println("This is a test for Google search.");
    // Initialize the WebDriver (e.g., ChromeDriver, FirefoxDriver, etc.)
    // For example, if using ChromeDriver:
    WebDriver webdriver = new org.openqa.selenium.chrome.ChromeDriver();
    webdriver.get("https://www.google.com");
    String title = webdriver.getTitle();
    System.out.println("Page title is: " + title);
    webdriver.quit();
    
}
    
}
