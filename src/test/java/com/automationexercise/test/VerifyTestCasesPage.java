package com.automationexercise.test;

import com.automationexercise.pages.HomePage;
import org.testng.annotations.Test;

public class VerifyTestCasesPage extends BaseTest {

    @Test
    public void VerifyTestCasesPage() {
        new HomePage(driver)
                .isHomePageObjVisible()
                .testCasesPage()
                .verifyTestCases();
    }
}
