package pom;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement signIntoAccountButton;

    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement orderButton;

    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement personalAccountButton;

    @FindBy(how = How.XPATH, using = ".//div[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement burgerLogo;
    @FindBy(how = How.CSS, using = ".AppHeader_header__link__3D_hX[href='/']")
    private SelenideElement constructorHeader;

    @FindBy(how = How.XPATH, using = ".//span[contains(text(),'Булки')]")
    private SelenideElement buns;

    @FindBy(how = How.XPATH, using = ".//span[contains(text(),'Соусы')]")
    private SelenideElement sauces;

    @FindBy(how = How.XPATH, using = ".//span[contains(text(),'Начинки')]")
    private SelenideElement fillings;

    public HomePage openPage(){
        open(URL);
        return page(HomePage.class);
    }
    public LoginPage clickSignInToAccountButton() {
        signIntoAccountButton.click();
        return page(LoginPage.class);
    }
    public LoginPage clickPersonalAccountButton() {
        personalAccountButton.click();
        return page(LoginPage.class);
    }
    public HomePage clickBurgerLogo() {
        burgerLogo.click();
        return page(HomePage.class);
    }
    public HomePage clickConstructorHeader() {
        constructorHeader.click();
        return page(HomePage.class);
    }
    public void clickBuns() {
        buns.click();
    }
    public void clickSauces() {
        sauces.click();
    }
    public void clickFillings() {
        fillings.click();
    }
    public HomePage orderButtonIsDisplayed() {
        boolean isDisplayed = orderButton.shouldBe(visible, Duration.ofSeconds(5)).isDisplayed();
        Assert.assertTrue("Кнопка оформить заказ не отображается", isDisplayed);
        return page(HomePage.class);
    }
    public HomePage signInToAccountButtonIsDisplayed() {
        boolean isDisplayed = signIntoAccountButton.shouldBe(visible, Duration.ofSeconds(5)).isDisplayed();
        Assert.assertTrue("Кнопка 'Вход в аккаунт' не отображается", isDisplayed);
        return page(HomePage.class);
    }
    public HomePage waitForLoadOrderButton() {
        orderButton.shouldBe(visible);
        return page(HomePage.class);
    }
    public String getTextActionButton() throws InterruptedException {
        Thread.sleep(1000);
        return $(By.className("tab_tab_type_current__2BEPc")).getText();
    }
    public String getAccessToken() {
        return localStorage().getItem("accessToken");
    }
}