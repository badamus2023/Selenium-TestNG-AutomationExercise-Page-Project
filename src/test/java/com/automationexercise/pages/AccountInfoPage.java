package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AccountInfoPage {
    protected WebDriver driver;
    @FindBy(id = "id_gender1")
    private WebElement mrCheckbox;
    @FindBy(id = "id_gender2")
    private WebElement mrsCheckbox;
    @FindBy(id = "password")
    private WebElement signUpPassword;
    @FindBy(xpath = "//h2//b[text()='Enter Account Information']")
    private WebElement AccInfTextVerification;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement specialOffersCheckbox;

    @FindBy(name = "first_name")
    private WebElement setFirstName;

    @FindBy(name = "last_name")
    private WebElement setLastName;

    @FindBy(name = "company")
    private WebElement setCompany;

    @FindBy(id = "address1")
    private WebElement setAddress;

    @FindBy(id = "state")
    private WebElement setState;

    @FindBy(id = "city")
    private WebElement setCity;

    @FindBy(id = "zipcode")
    private WebElement setZipCode;

    @FindBy(id = "mobile_number")
    private WebElement setMobileNumber;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccountButton;

    public AccountInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public AccountInfoPage accInfVerification() {
        Assert.assertTrue(AccInfTextVerification.isDisplayed());
        return this;
    }

    public AccountInfoPage setAccountInformation(String title_Mr_Mrs, String password, int newsLetterValue, int specialOfferValue, int day, int month, int year) {
        switch (title_Mr_Mrs) {
            case "Mr":
                mrCheckbox.click();
                break;
            case "Mrs":
                mrsCheckbox.click();
                break;
        }
        signUpPassword.sendKeys(password);
        driver.findElement(By.xpath("//select[@id='days']//option[@value=" + day + "]")).click();
        driver.findElement(By.xpath("//select[@id='months']//option[@value=" + month + "]")).click();
        driver.findElement(By.xpath("//select[@id='years']//option[text()='" + year + "']")).click();
        if (newsLetterValue == 1)
            newsletterCheckbox.click();
        if (specialOfferValue == 1)
            specialOffersCheckbox.click();
        return this;
    }

    public AccountInfoPage setAddressInformation(String firstName, String lastName, String company, String address, String country, String state, String city, String zipCode, String mobileNumber) {
        setFirstName.sendKeys(firstName);
        setLastName.sendKeys(lastName);
        setCompany.sendKeys(company);
        setAddress.sendKeys(address);
        driver.findElement(By.xpath("//select[@id='country']//option[text()='" + country + "']")).click();
        setState.sendKeys(state);
        setCity.sendKeys(city);
        setZipCode.sendKeys(zipCode);
        setMobileNumber.sendKeys(mobileNumber);
        return this;
    }

    public LoggedUserPage createAccountButton() {
        createAccountButton.click();
        return new LoggedUserPage(driver);
    }
}
