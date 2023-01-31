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
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.isChrome;

public class SelenideTest extends BaseTest {

    @Test
    public void loginTest() {
        open("/");

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#password").val(ReadProperties.password());

        SelenideElement loginButton = $("#button_primary");
        loginButton
                .should(exist)
                .shouldBe(enabled)
                .click();
        //loginButton.pressEnter();
        //loginButton.selectOption(...);
        //loginButton.append(...);
        //loginButton.attr(...);

/*
        $(withText("All Projects"))
                .shouldBe(visible)
                .shouldHave(text("All Projects"));
*/

        $(By.xpath("//div[contains(text(), 'All Projects')]"))
                .shouldBe(visible)
                .shouldHave(text("All Projects"));

        $(withText("All Projects"))
                .shouldBe(visible)
                .shouldHave(text("All Projects"));

        $(byText("All Projects"))
                .shouldBe(visible)
                .shouldHave(text("All Projects"));

        $(byTitle("All Projects"))
                .shouldBe(visible)
                .shouldHave(text("All Projects"));

//        $(byValue("All Projects"))
//                .shouldBe(visible)
//                .shouldHave(text("All Projects"));

        $$(withText("All Projects"))
                .shouldBe(empty)
                .shouldBe(size(10))
                .shouldHave(texts("text 1", "text 2", "text 3"))
                .shouldHave(exactTexts(("text 1", "text 2", "text 3"));
                // textsInAnyOrder(...)

        $$(withText("All Projects"))
                .filterBy(text("Expected text"))
                .excludeWith(hidden);
                //.get(1);
                //.findBy(visible);

        isChrome();
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
