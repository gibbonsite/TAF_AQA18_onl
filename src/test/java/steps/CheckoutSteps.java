package steps;

import baseEntities.BaseStep;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.*;
import pages.checkout.CheckoutCompletePage;
import pages.checkout.CheckoutInformationPage;
import pages.checkout.CheckoutOverviewPage;

public class CheckoutSteps extends BaseStep {
    private CataloguePage cataloguePage;
    private CartPage cartPage;
    private CheckoutInformationPage checkoutInformationPage;
    private CheckoutOverviewPage checkoutOverviewPage;

    public CheckoutSteps(WebDriver driver) {
        super(driver);

        cataloguePage = new CataloguePage(driver);
        cartPage = new CartPage(driver);
        checkoutInformationPage = new CheckoutInformationPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
    }

    public CheckoutSteps addToCart() {
        cataloguePage.addToCartSauceLabsFleeceJacketElement.click();
        return this;
    }

    public CheckoutSteps goToCartPage() {
        cartPage.openPageByUrl();
        return this;
    }

    public CheckoutSteps proceedToCheckout() {
        cartPage.checkoutButton.click();
        return this;
    }

    public CheckoutSteps proceedToCheckoutOverview(User user) {
        checkoutInformationPage.firstNameInput.sendKeys(user.getFirstname());
        checkoutInformationPage.lastNameInput.sendKeys(user.getLastname());
        checkoutInformationPage.postalCodeInput.sendKeys(user.getZipCode());
        checkoutInformationPage.continueButton.click();
        return this;
    }

    public CheckoutCompletePage finishPayment() {
        checkoutOverviewPage.finishButton.click();
        return new CheckoutCompletePage(driver);
    }
}
