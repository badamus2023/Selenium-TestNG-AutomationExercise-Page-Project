package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsPage {

    protected WebDriver driver;

    @FindBy(xpath = "//h2[text()='Get In Touch']")
    private WebElement contactPageVisibility;

    @FindBy(name = "name")
    private WebElement contactNameInput;

    @FindBy(name = "email")
    private WebElement contactEmailInput;

    @FindBy(name = "subject")
    private WebElement contactSubjectInput;

    @FindBy(name = "message")
    private WebElement contactMessageInput;

    @FindBy(name = "upload_file")
    private WebElement uploadFileButton;

    @FindBy(name = "submit")
    private WebElement contactSubmitButton;

    public ContactUsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ContactUsPage fillContactDetails(String name, String email, String subject, String message) {
        String pathToFile = "C:\\Users\\Bartosz\\Desktop\\git hub.txt";
        contactNameInput.sendKeys(name);
        contactEmailInput.sendKeys(email);
        contactSubjectInput.sendKeys(subject);
        contactMessageInput.sendKeys(message);
        uploadFileButton.sendKeys(pathToFile);
        contactSubmitButton.click();
        driver.switchTo().alert().accept();
        return this;
    }

    public ContactUsPage contactCheckVisibility() {
        Assert.assertTrue(contactPageVisibility.isDisplayed());
        return this;
    }
}
