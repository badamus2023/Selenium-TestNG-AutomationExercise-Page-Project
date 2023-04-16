package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedUserPage {
    protected WebDriver driver;

    @FindBy(xpath = "//h2[@data-qa]")
    private WebElement accCreatedText;

    @FindBy(xpath = "//a[text() ='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//a[text()=' Delete Account']")
    private WebElement deleteAccount;

    @FindBy(xpath = "//h2[@data-qa='account-deleted']")
    private WebElement accDeletedVerfication;

    @FindBy(id = "dismiss-button")
    private WebElement dissMissButton;

    @FindBy(xpath = "//b[text()='Bartosz']")
    private WebElement nameVerification;

    @FindBy(xpath = "//i[@class='fa fa-lock']")
    private WebElement logoutButton;

    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoggedUserPage accCreationVerfication() {
        accCreatedText.isDisplayed();
        return this;
    }

    public LoggedUserPage continueButton() {
        continueButton.click();
        return this;
    }

    public LoggedUserPage deleteAcc() {
        deleteAccount.click();
        return this;
    }

    public LoggedUserPage dissMissButton() {
        driver.switchTo().frame(dissMissButton);
        dissMissButton.click();
        dissMissButton.click();
        return this;
    }

    public LoggedUserPage accDeletedVerfication() {
        accDeletedVerfication.isDisplayed();
        return this;
    }

    public LoggedUserPage usernameVerification() {
        nameVerification.isDisplayed();
        return this;
    }

    public SignUpPage logoutButton() {
        logoutButton.click();
        return new SignUpPage(driver);
    }

}
