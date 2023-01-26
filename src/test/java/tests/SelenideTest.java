package tests;

import baseEntities.BaseTest;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest extends BaseTest {

    @Test
    public void loginTest() {
        open("/");

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());

        SelenideElement loginButton = $("#button_primary");
        loginButton
                .should(exist)
                .shouldBe(enabled)
                .click();

/*
        $(withText("All Projects"))
                .shouldBe(visible)
                .shouldHave(text("All Projects"));
*/

        $(By.xpath("//div[contains(text(), 'All Projects')]"))
                .shouldBe(visible)
                .shouldHave(text("All Projects"));

/*
        $$(withText("All Projects"))
                .shouldBe(empty)
                .shouldBe(size(10))
                .texts();
*/
    }

    @Test
    public void loginTest2() {
        open("/");

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());

        SelenideElement loginButton = $("#button_primary");
        loginButton
                .should(exist)
                .shouldBe(enabled)
                .click();

        $(By.xpath("//div[contains(text(), 'All Projects')]"))
                .shouldBe(visible)
                .shouldHave(text("All Projects"));
    }
}
