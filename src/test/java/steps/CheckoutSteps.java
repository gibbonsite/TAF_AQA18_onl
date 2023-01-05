package steps;

import baseEntities.BaseStep;
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

    public void addToCart() {
        cataloguePage.getAddToCartSauceLabsFleeceJacketElement().click();
    }

    public CheckoutInformationPage proceedToCheckout() {
        cartPage.getCheckoutButton().click();

        return checkoutInformationPage;
    }

    public CheckoutOverviewPage proceedToCheckoutOverview() {
        checkoutInformationPage.getFirstNameInput().sendKeys("Maksim");
        checkoutInformationPage.getLastNameInput().sendKeys("Paliashchuk");
        checkoutInformationPage.getPostalCodeInput().sendKeys("220018");
        checkoutInformationPage.getContinueButton().click();

        return checkoutOverviewPage;
    }

    public CheckoutCompletePage finishPayment() {
        checkoutOverviewPage.getFinishButton().click();

        return new CheckoutCompletePage(driver);
    }
}
