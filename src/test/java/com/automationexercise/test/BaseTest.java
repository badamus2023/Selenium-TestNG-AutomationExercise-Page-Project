package com.automationexercise.test;

import com.automationexercise.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Set;


public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com/");
        String currentWindow = driver.getWindowHandle();
        Set<String> windowNames = driver.getWindowHandles();
        for (String window : windowNames) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                driver.close();
                driver.switchTo().window(currentWindow);
            }
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
