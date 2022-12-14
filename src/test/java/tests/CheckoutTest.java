package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutOverviewPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutSuccessfulTest() {

        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        checkoutSteps.addToCart();
        CartPage cartPage = navigationSteps.navigateToCartPage();

        Assert.assertEquals(cartPage.getCartQuantityElements().size(), 1);
        Assert.assertEquals(cartPage.getCartQuantityElements().get(0).getText(), "1");
        Assert.assertEquals(cartPage.getInventoryItemNameElements().size(), 1);
        Assert.assertEquals(cartPage.getInventoryItemNameElements().get(0).getText(), "Sauce Labs Fleece Jacket");

        checkoutSteps.proceedToCheckout();
        CheckoutOverviewPage checkoutOverviewPage = checkoutSteps.proceedToCheckoutOverview();

        Assert.assertTrue(checkoutOverviewPage.getPaymentInformationElement().getText().startsWith("SauceCard"));
        Assert.assertEquals(checkoutOverviewPage.getShippingInformationElement().getText(), "FREE PONY EXPRESS DELIVERY!");
        Assert.assertEquals(checkoutOverviewPage.getTotalPriceElement().getText(), "Total: $53.99");
        Assert.assertTrue(checkoutSteps.finishPayment().isPageOpened());
    }
}
