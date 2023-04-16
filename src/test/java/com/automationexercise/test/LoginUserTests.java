package com.automationexercise.test;

import com.automationexercise.pages.HomePage;
import org.testng.annotations.Test;

public class LoginUserTests extends BaseTest {
    @Test
    public void loginUserWithInvalidData() {
        new HomePage(driver)
                .isHomePageObjVisible()
                .signUpPage()
                .loginTextVerification()
                .loginWithInvalidData("Janek123@gmail.com", "Fubu111222")
                .loginErrorVerification();
    }

    @Test
    public void loginUserWithValidData() {
        String name = "Bartosz";
        new HomePage(driver)
                .isHomePageObjVisible()
                .signUpPage()
                .loginTextVerification()
                .loginWithValidData("bartosz.adamus321@gmail.com", "Qwerty123")
                .usernameVerification();
        //.deleteAcc()
        //.accDeletedVerfication();
    }
}
