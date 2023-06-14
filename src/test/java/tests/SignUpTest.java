package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import model.api.UserClient;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pom.HomePage;
import pom.SignUpPage;

public class SignUpTest {
    HomePage homePage = Selenide.page(HomePage.class);
    SignUpPage signUpPage = Selenide.page(SignUpPage.class);
    UserClient userClient = new UserClient();
    String name;
    String email;
    String password;
    String accessToken;

    @Before
    public void setUp() {
        name = RandomStringUtils.randomAlphabetic(8);
        email = RandomStringUtils.randomAlphabetic(8) + "@yandex.ru";
        password = RandomStringUtils.randomAlphabetic(6);
    }
    @Test
    @DisplayName("Registration user with valid data")
    public void signUpUserWithValidData() {
        accessToken = homePage
                .openPage()
                .clickSignInToAccountButton()
                .clickSignUpLink()
                .registrationUser(name, email, password)
                .waitLoadPage()
                .loginUser(email, password)
                .orderButtonIsDisplayed()
                .getAccessToken();
    }
    @Test
    @DisplayName("Get message error, with registration user with wrong data")
    public void signUpUserWithIncorrectPassword() {
        homePage
                .openPage()
                .clickSignInToAccountButton()
                .clickSignUpLink()
                .registrationUser(name, email, RandomStringUtils.randomAlphabetic(5));
        signUpPage.errorPasswordIsDisplayed();
    }
    @After
    public void tearDown() {
        if (accessToken != null) {
            userClient.deleteUser(accessToken)
                    .then()
                    .log().all();
            accessToken = null;
        }
    }
}