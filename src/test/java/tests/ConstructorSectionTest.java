package tests;

import com.codeborne.selenide.Configuration;
import org.junit.Before;
import pom.HomePage;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class ConstructorSectionTest {
    HomePage mainPage = Selenide.page(HomePage.class);

    @Before
    public void setUp(){
        Configuration.browser = "firefox";
        //Configuration.browser = "yandex";
    }

    @Test
    @DisplayName("Check sections selected")
    public void goToSectionsTest() throws InterruptedException {
        mainPage
                .openPage()
                .clickFillings();
        Assert.assertEquals("Начинки", mainPage.getTextActionButton());

        mainPage
                .clickSauces();
        Assert.assertEquals("Соусы", mainPage.getTextActionButton());

        mainPage
                .clickBuns();
        Assert.assertEquals("Булки", mainPage.getTextActionButton());
    }
}