package com.automationexercise.test;

import com.automationexercise.pages.HomePage;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest {
    @Test
    public void logoutTest() {
        new HomePage(driver)
                .isHomePageObjVisible()
                .signUpPage()
                .loginTextVerification()
                .loginWithValidData("bartosz.adamus321@gmail.com", "Qwerty123")
                .usernameVerification()
                .logoutButton()
                .loginTextVerification();
    }

}
