package pom;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class SignUpPage {
    private final String URL = "https://stellarburgers.nomoreparties.site/register";

    @FindBy(how = How.XPATH, using = "//h2[text()='Регистрация']")
    private SelenideElement registerHeader;
    @FindBy(how = How.XPATH, using = "//fieldset[1]/div/div/input")
    private SelenideElement nameField;
    @FindBy(how = How.XPATH, using = "//fieldset[2]/div/div/input")
    private SelenideElement emailField;
    @FindBy(how = How.XPATH, using = "//fieldset[3]/div/div/input")
    private SelenideElement passwordField;
    @FindBy(how = How.XPATH, using = "//button[text()='Зарегистрироваться']")
    private SelenideElement registrationButton;
    @FindBy(how = How.CSS, using = ".Auth_link__1fOlj[href='/login']")
    private SelenideElement loginButton;
    @FindBy(how = How.XPATH, using = "//p[text()='Некорректный пароль']")
    private SelenideElement errorPassword;
    @FindBy(how = How.XPATH, using = "//p[text()='Такой пользователь уже существует']")
    private SelenideElement errorUserIsAlreadyRegistered;

    public SignUpPage openPage(){
        open(URL);
        return page(SignUpPage.class);
    }
    public SignUpPage setName(String name) {
        nameField.setValue(name);
        return page(SignUpPage.class);
    }
    public SignUpPage setEmail(String email) {
        emailField.setValue(email);
        return page(SignUpPage.class);
    }
    public SignUpPage setPassword(String password) {
        passwordField.setValue(password);
        return page(SignUpPage.class);
    }
    public LoginPage clickRegistrationButton() {
        registrationButton.click();
        return page(LoginPage.class);
    }
    public LoginPage clickLoginButton() {
        loginButton.click();
        return page(LoginPage.class);
    }
    public LoginPage registrationUser(String name, String email, String password) {
        setName(name).
                setEmail(email).
                setPassword(password).
                clickRegistrationButton();
        return page(LoginPage.class);
    }
    public SignUpPage errorUserIsAlreadyRegisteredIsDisplayed() {
        boolean isDisplayed = errorUserIsAlreadyRegistered.shouldBe(visible, Duration.ofSeconds(5)).isDisplayed();
        Assert.assertTrue("Ошибка 'Пользователь уже существует' не отображается", isDisplayed);
        return page(SignUpPage.class);
    }
    public SignUpPage errorPasswordIsDisplayed() {
        boolean isDisplayed = errorPassword.shouldBe(visible, Duration.ofSeconds(5)).isDisplayed();
        Assert.assertTrue("Ошибка 'Не корректный пароль' не отображается", isDisplayed);
        return page(SignUpPage.class);
    }
}