package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutSuccessfulTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        checkoutSteps.addToCart();
        navigationSteps.navigateToCartPage();
        checkoutSteps.proceedToCheckout();
        checkoutSteps.proceedToCheckoutOverview();

        Assert.assertTrue(checkoutSteps.finishPayment().isPageOpened());
    }
}
