package com.automationexercise.test;

import com.automationexercise.pages.HomePage;
import org.testng.annotations.Test;

public class SignupUserTests extends BaseTest {

    @Test
    public void userRegistration() {
        int randomNumber = (int) (Math.random() * 1000);
        String email = "testowy" + randomNumber + "@gmail.com";
        //String email = "bartosz.adamus321@gmail.com";
        new HomePage(driver)
                .isHomePageObjVisible()
                .signUpPage()
                .textVerification()
                .signUpUserWithValidData("Bartosz", email)
                .accInfVerification()
                .setAccountInformation("Mr", "Qwerty123", 0, 1, 27, 4, 2002)
                .setAddressInformation("Bartosz", "Adamus", "wlasna-dzialalnosc", "Krakow", "Singapore", "Malopolskie", "Krakow", "34-120", "123123123")
                .createAccountButton()
                .accCreationVerfication()
                .continueButton()
                .deleteAcc()
                .accDeletedVerfication()
                .continueButton();
    }

    @Test
    public void userSignupWithInvalidData() {
        new HomePage(driver)
                .isHomePageObjVisible()
                .signUpPage()
                .loginTextVerification()
                .signUpUserWithInvalidData("Bartosz", "bartosz.adamus321@gmail.com")
                .signupErrorVerification();
    }
}
