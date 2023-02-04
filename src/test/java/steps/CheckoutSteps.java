package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CataloguePage;
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

    public CheckoutSteps proceedToCheckoutOverview(String firstName, String lastName, String postalCode) {
        checkoutInformationPage.firstNameInput.sendKeys(firstName);
        checkoutInformationPage.lastNameInput.sendKeys(lastName);
        checkoutInformationPage.postalCodeInput.sendKeys(postalCode);
        checkoutInformationPage.continueButton.click();
        return this;
    }

    public CheckoutCompletePage finishPayment() {
        checkoutOverviewPage.finishButton.click();
        return new CheckoutCompletePage(driver);
    }
}
