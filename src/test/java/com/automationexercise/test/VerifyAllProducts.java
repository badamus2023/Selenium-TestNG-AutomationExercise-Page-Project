package com.automationexercise.test;


import com.automationexercise.pages.HomePage;
import org.testng.annotations.Test;

public class VerifyAllProducts extends BaseTest {
    @Test
    public void VerifyAllProducts() {
        new HomePage(driver)
                .isHomePageObjVisible()
                .productsPage();
    }
}
