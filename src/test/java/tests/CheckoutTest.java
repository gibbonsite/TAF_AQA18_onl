package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutSuccessfulTest() {
        User user = new User.Builder()
                .withEmail(ReadProperties.username())
                .withPassword(ReadProperties.password())
                .withFirstname("Ivan")
                .withLastname("Petrov")
                .withZipCode("200019")
                .build();

        Assert.assertTrue(
                userSteps.loginSuccessful(user)
                .addToCart()
                .goToCartPage()
                .proceedToCheckout()
                .proceedToCheckoutOverview(user)
                .finishPayment()
                .isPageOpened());
    }
}
