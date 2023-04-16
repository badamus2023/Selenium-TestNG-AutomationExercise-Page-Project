package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SignUpPage {
    protected WebDriver driver;

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    private WebElement textVerification;
    @FindBy(name = "name")
    private WebElement signUpName;
    @FindBy(xpath = "//form//input[@data-qa='signup-email']")
    private WebElement signUpEmail;
    @FindBy(xpath = "//button[text()='Signup']")
    private WebElement submitButton;

    @FindBy(xpath = "//h2[text()='Login to your account']")
    private WebElement loginTextVerification;

    @FindBy(xpath = "//form//input[@data-qa='login-email']")
    private WebElement logInEmail;

    @FindBy(xpath = "//form//input[@data-qa='login-password']")
    private WebElement logInPassword;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    private WebElement loginError;

    @FindBy(xpath = "//p[text()='Email Address already exist!']")
    private WebElement signupError;


    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public AccountInfoPage signUpUserWithValidData(String validName, String validEmail) {
        fillSignupData(validEmail, validName);
        return new AccountInfoPage(driver);
    }

    public SignUpPage signUpUserWithInvalidData(String invalidName, String invalidEmail) {
        fillSignupData(invalidEmail, invalidName);
        return this;
    }

    public SignUpPage textVerification() {
        Assert.assertTrue(textVerification.isDisplayed());
        return this;
    }

    public SignUpPage loginTextVerification() {
        Assert.assertTrue(loginTextVerification.isDisplayed());
        return this;
    }

    public SignUpPage loginWithInvalidData(String invalidEmail, String invalidPassword) {
        fillLoginData(invalidEmail, invalidPassword);
        return this;
    }

    public LoggedUserPage loginWithValidData(String validEmail, String validPassword) {
        fillLoginData(validEmail, validPassword);
        return new LoggedUserPage(driver);
    }

    public SignUpPage loginErrorVerification() {
        Assert.assertTrue(loginError.isDisplayed());
        return this;
    }

    public SignUpPage signupErrorVerification() {
        Assert.assertTrue(signupError.isDisplayed());
        return this;
    }

    private void fillSignupData(String signupEmail, String signupName) {
        signUpEmail.sendKeys(signupEmail);
        signUpName.sendKeys(signupName);
        submitButton.click();
    }

    private void fillLoginData(String loginEmail, String loginPassword) {
        logInEmail.sendKeys(loginEmail);
        logInPassword.sendKeys(loginPassword);
        loginButton.click();
    }
}
