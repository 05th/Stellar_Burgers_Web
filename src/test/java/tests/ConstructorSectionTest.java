package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pom.HomePage;

public class ConstructorSectionTest {
    HomePage homePage = Selenide.page(HomePage.class);
    @Test
    @DisplayName("Check try Section select")
    public void goToSectionsTest() throws InterruptedException {
        homePage
                .openPage()
                .clickFillings();
        Assert.assertEquals("Начинки", homePage.getTextActionButton());

        homePage
                .clickSauces();
        Assert.assertEquals("Соусы", homePage.getTextActionButton());

        homePage
                .clickBuns();
        Assert.assertEquals("Булки", homePage.getTextActionButton());
    }
}