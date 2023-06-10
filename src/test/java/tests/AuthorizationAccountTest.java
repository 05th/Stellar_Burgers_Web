package tests;

import model.api.UserClient;
import com.codeborne.selenide.Configuration;
import model.api.UserRandomDataGenerator;
import pom.HomePage;
import pom.PersonalAccountPage;
import pom.PasswordRecoveryPage;
import pom.SignUpPage;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

@DisplayName("Authorization")
public class AuthorizationAccountTest {
    HomePage mainPage = Selenide.page(HomePage.class);
    SignUpPage registrationPage = Selenide.page(SignUpPage.class);
    PasswordRecoveryPage recoverPage = Selenide.page(PasswordRecoveryPage.class);
    PersonalAccountPage profilePage = Selenide.page(PersonalAccountPage.class);
    UserClient userClient = new UserClient();
    UserRandomDataGenerator userRandomDataGenerator = new UserRandomDataGenerator();
    String accessToken;
    String email;
    String name;
    String password;

    @Before
    public void setUp() {
        Configuration.browser = "firefox";
        //Configuration.browser = "yandex";
        Map<String, String> generatedDataUser = userRandomDataGenerator.getMapGeneratedDataUser();
        email = generatedDataUser.get("email");
        name = generatedDataUser.get("name");
        password = generatedDataUser.get("password");
        accessToken = userClient.createUser(generatedDataUser).then().extract().body().path("accessToken");
    }

    @Test
    @DisplayName("SignIn from Home page")
    public void authorizationLoginFromHomePage() {
        mainPage
                .openPage()
                .clickSignInToAccountButton()
                .loginUser(email, password)
                .orderButtonIsDisplayed();
    }

    @Test
    @DisplayName("SignIn from personal account»")
    public void authorizationPersonalAccountButtonOnHomePage() {
        mainPage
                .openPage()
                .clickPersonalAccountButton()
                .loginUser(email, password)
                .orderButtonIsDisplayed();
    }

    @Test
    @DisplayName("SignIn from registration page")
    public void authorizationEntryButtonOnSingUpPage() {
        registrationPage
                .openPage()
                .clickLoginButton()
                .loginUser(email, password)
                .orderButtonIsDisplayed();
    }

    @Test
    @DisplayName("SignIn from recovery page")
    public void authorizationEntryButtonOnPasswordRecoveryPage() {
        recoverPage
                .openPage()
                .clickLoginButton()
                .loginUser(email, password)
                .orderButtonIsDisplayed();
    }

    @Test
    @DisplayName("LogIn to personal account")
    public void goToPersonalAccountTest() {
        mainPage
                .openPage()
                .clickSignInToAccountButton()
                .loginUser(email, password)
                .clickPersonalAccountButton();
        profilePage.visibleProfileButton();
    }

    @Test
    @DisplayName("LogOut from personal account")
    public void logoutAccount() {
        mainPage
                .openPage()
                .clickSignInToAccountButton()
                .loginUser(email, password)
                .clickPersonalAccountButton();
        profilePage
                .logOutFromAccount()
                .waitLoadPage();
    }

    @Test
    @DisplayName("Go to Home page by click header constructor")
    public void goToHomePageByHeaderConstructor() {
        mainPage
                .openPage()
                .clickSignInToAccountButton()
                .loginUser(email, password)
                .clickPersonalAccountButton();
        profilePage
                .clickConstructorHeader()
                .orderButtonIsDisplayed();
    }

    @Test
    @DisplayName("Go to Home page by click burger logo")
    public void goToHomePageByLogoBurger() {
        mainPage
                .openPage()
                .clickSignInToAccountButton()
                .loginUser(email, password)
                .clickPersonalAccountButton();
        profilePage
                .clickOnBurgerLogo()
                .orderButtonIsDisplayed();
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