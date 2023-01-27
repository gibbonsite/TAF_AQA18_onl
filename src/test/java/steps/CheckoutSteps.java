package steps;

import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.CartPage;
import pages.CataloguePage;
import pages.checkout.CheckoutCompletePage;
import pages.checkout.CheckoutInformationPage;
import pages.checkout.CheckoutOverviewPage;

public class CheckoutSteps {
    private Logger logger = LogManager.getLogger();
    private CataloguePage cataloguePage;
    private CartPage cartPage;
    private CheckoutInformationPage checkoutInformationPage;
    private CheckoutOverviewPage checkoutOverviewPage;

    public CheckoutSteps() {
        cataloguePage = new CataloguePage();
        cartPage = new CartPage();
        checkoutInformationPage = new CheckoutInformationPage();
        checkoutOverviewPage = new CheckoutOverviewPage();
    }

    public CheckoutSteps addToCart() {
        cataloguePage.getAddToCartSauceLabsFleeceJacketElement().click();
        return this;
    }

    public CheckoutSteps goToCartPage() {
        cartPage.openPageByUrl();
        return this;
    }

    public CheckoutSteps proceedToCheckout() {
        cartPage.getCheckoutButton().click();
        return this;
    }

    public CheckoutSteps proceedToCheckoutOverview(User user) {
        logger.info("In step CheckoutSteps user object is used, which contains the following details: " + user);

        checkoutInformationPage.getFirstNameInput().setValue(user.getFirstname());
        checkoutInformationPage.getLastNameInput().setValue(user.getLastname());
        checkoutInformationPage.getPostalCodeInput().setValue(user.getZipCode());
        checkoutInformationPage.getContinueButton().click();
        return this;
    }

    public CheckoutCompletePage finishPayment() {
        checkoutOverviewPage.getFinishButton().click();
        return new CheckoutCompletePage();
    }
}
