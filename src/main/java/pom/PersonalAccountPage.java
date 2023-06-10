package pom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class PersonalAccountPage {
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement logOutButton;
    @FindBy(how = How.CSS, using = "a[href='/account/profile']")
    private SelenideElement profileButton;

    @FindBy(how = How.XPATH, using = ".//div[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement burgerLogo;

    @FindBy(how = How.CSS, using = ".AppHeader_header__link__3D_hX[href='/']")
    private SelenideElement constructorHeader;


    public LoginPage logOutFromAccount(){
        logOutButton.click();
        return page(LoginPage.class);
    }


    public PersonalAccountPage visibleProfileButton(){
        boolean isDisplayed = profileButton.shouldBe(visible, Duration.ofSeconds(5)).isDisplayed();
        Assert.assertTrue("Кнопка 'Профиль' не отображается", isDisplayed);
        return page(PersonalAccountPage.class);
    }


    public HomePage clickOnBurgerLogo() {
        burgerLogo.click();
        return Selenide.page(HomePage.class);
    }


    public HomePage clickConstructorHeader() {
        constructorHeader.click();
        return Selenide.page(HomePage.class);
    }


    public void waitLoadPage() {
        profileButton.shouldBe(Condition.visible);
    }
}