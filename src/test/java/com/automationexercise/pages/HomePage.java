package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    protected WebDriver driver;
    @FindBy(xpath = "//h2[text()='Features Items']")
    private WebElement homePageObject;

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement signUpPage;

    @FindBy(xpath = "//a[text()=' Test Cases']")
    private WebElement testCasesLink;

    @FindBy(xpath = "//a[text()=' Contact us']")
    private WebElement contactUsLink;

    @FindBy(xpath = "//a[text()=' Products']")
    private WebElement productsLink;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public SignUpPage signUpPage() {
        signUpPage.click();
        return new SignUpPage(driver);
    }

    public HomePage isHomePageObjVisible() {
        homePageObject.isDisplayed();
        return this;
    }

    public ContactUsPage contactUsPage() {
        contactUsLink.click();
        return new ContactUsPage(driver);
    }

    public TestCasesPage testCasesPage() {
        testCasesLink.click();
        return new TestCasesPage(driver);
    }

    public ProductsPage productsPage() {
        productsLink.click();
        return new ProductsPage(driver);
    }
}
