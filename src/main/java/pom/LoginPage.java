package pom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private final String baseURL = "https://stellarburgers.nomoreparties.site/login";

    @FindBy(how = How.XPATH, using = ".//a[text()='Зарегистрироваться']")
    private SelenideElement signUpLink;

    @FindBy(how = How.XPATH, using = "//h2[text()='Вход']")
    private SelenideElement entranceHeader;

    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement signInButton;

    @FindBy(how = How.XPATH, using = ".//a[text()='Восстановить пароль']")
    private SelenideElement recoveryPasswordLink;

    public LoginPage openLoginPage() {
        open(baseURL);
        return page(LoginPage.class);
    }

    public SignUpPage clickSignUpLink() {
        signUpLink.shouldBe(visible).click();
        return Selenide.page(SignUpPage.class);
    }

    public LoginPage setEmail(String email) {
        emailField.setValue(email);
        return page(LoginPage.class);
    }

    public LoginPage setPassword(String password) {
        passwordField.setValue(password);
        return page(LoginPage.class);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public PasswordRecoveryPage clickRecoveryPasswordLink() {
        recoveryPasswordLink.click();
        return Selenide.page(PasswordRecoveryPage.class);
    }

    public HomePage loginUser(String email, String password) {
        setEmail(email).
                setPassword(password).
                clickSignInButton();
        return Selenide.page(HomePage.class);
    }

    public LoginPage waitLoadPage() {
        entranceHeader.shouldBe(Condition.visible);
        return page(LoginPage.class);
    }
}