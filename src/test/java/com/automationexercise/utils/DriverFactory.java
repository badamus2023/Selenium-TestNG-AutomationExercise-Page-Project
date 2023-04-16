package com.automationexercise.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    public static WebDriver getDriver() {
        String path_to_extension = "C:\\Users\\Bartosz\\Desktop\\5.4.1_0";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("load-extension=" + path_to_extension);
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }
}
