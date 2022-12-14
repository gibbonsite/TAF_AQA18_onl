package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;

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

    public void proceedToCheckout() {
        cartPage.getCheckoutButton().click();
    }

    public CheckoutOverviewPage proceedToCheckoutOverview() {
        checkoutInformationPage.getFirstNameInput().sendKeys("Maksim");
        checkoutInformationPage.getLastNameInput().sendKeys("Paliashchuk");
        checkoutInformationPage.getPostalCodeInput().sendKeys("220018");
        checkoutInformationPage.getContinueButton().click();

        return new CheckoutOverviewPage(driver);
    }

    public CheckoutCompletePage finishPayment() {
        checkoutOverviewPage.getFinishButton().click();

        return new CheckoutCompletePage(driver);
    }
}
