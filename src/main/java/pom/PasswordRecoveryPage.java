package pom;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class PasswordRecoveryPage {
    private final String URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    @FindBy(how = How.XPATH, using = "//h2[text()='Восстановление пароля']")
    private SelenideElement recoveryPasswordHeader;

    @FindBy(how = How.CSS, using = "input[name='name']")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = "//button[text()='Восстановить']")
    private SelenideElement recoveryButton;

    @FindBy(how = How.CSS, using = ".Auth_link__1fOlj[href='/login']")
    private SelenideElement loginButton;


    public PasswordRecoveryPage openPage(){
        open(URL);
        return page(PasswordRecoveryPage.class);
    }


    public void setEmail(String email) {
        emailField.setValue(email);
    }


    public LoginPage clickLoginButton() {
        loginButton.click();
        return page(LoginPage.class);
    }
}