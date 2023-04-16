package com.automationexercise.test;

import com.automationexercise.pages.HomePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ContactUsTest extends BaseTest {
    @Test
    public void contactUsTest() {
        new HomePage(driver)
                .isHomePageObjVisible()
                .contactUsPage()
                .contactCheckVisibility()
                .fillContactDetails("Bartosz", "bartosz.adamus@gmail.com", "Test", "Janek");
    }
}
