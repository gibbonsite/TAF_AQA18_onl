package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    private Logger logger = LogManager.getLogger();

    @Test
    public void checkoutSuccessfulTest() {
        logger.info("Pattern Builder is used in test method in class CheckoutTest.");

        User user = User.builder()
                .email(ReadProperties.username())
                .password(ReadProperties.password())
                .firstname("Ivan")
                .lastname("Petrov")
                .zipCode("200019")
                .build();

        logger.info("Pattern Chain of Invocations is implemented in test method in class CheckoutTest.");

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
