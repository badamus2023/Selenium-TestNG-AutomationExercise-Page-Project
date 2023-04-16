package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TestCasesPage {

    @FindBy(xpath = "//b[text()='Test Cases']")
    private WebElement testCasesVerification;

    protected WebDriver driver;

    public TestCasesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public TestCasesPage verifyTestCases() {
        Assert.assertTrue(testCasesVerification.isDisplayed());
        return this;
    }


}
