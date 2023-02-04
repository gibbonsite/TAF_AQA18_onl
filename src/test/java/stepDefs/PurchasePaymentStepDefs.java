package stepDefs;

import baseEntities.BaseCucumberTest;
import configuration.ReadProperties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.checkout.CheckoutCompletePage;
import steps.CheckoutSteps;
import steps.UserSteps;

public class PurchasePaymentStepDefs extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;
    private CheckoutSteps checkoutSteps;
    private CheckoutCompletePage checkoutCompletePage;

    public PurchasePaymentStepDefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @Given("страница логина открыта")
    public void openLoginPage() {
        driver.get(ReadProperties.getUrl());
    }

    @When("пользователь {string} с паролем {string} залогинен")
    public void userWithPasswordLoggedIn(String username, String password) {
        UserSteps userSteps = new UserSteps(driver);
        checkoutSteps = userSteps.loginSuccessful(username, password);
    }


    @And("товар добавлен в корзину")
    public void goodIsAddedToCart() {
        checkoutSteps.addToCart();
    }
    @And("страница корзины открыта")
    public void openCartPage() {
        checkoutSteps.goToCartPage();
    }

    @And("страница персональных данных покупателя открыта")
    public void openCheckoutInformationPage() {
        checkoutSteps.proceedToCheckout();
    }

    @And("пользователь ввёл персональные данные - имя {string}, фамилию {string} и почтовый код {string}")
    public void enterUserPersonalData(String firstName, String lastName, String postalCode) {
        checkoutSteps.proceedToCheckoutOverview(firstName, lastName, postalCode);
    }

    @When("оплата завершена")
    public void finishPayment() {
        checkoutCompletePage = checkoutSteps.finishPayment();
    }

    @Then("страница завершения оплаты открыта")
    public void openPaymentFinishedPage() {
        Assert.assertTrue(checkoutCompletePage.isPageOpened());
    }
}
